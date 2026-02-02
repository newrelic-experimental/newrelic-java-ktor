import de.undercouch.gradle.tasks.download.Download
import org.gradle.api.tasks.Input
import java.io.*

// Build.gradle for creating or installing new instrumentation modules


// Global defaults - override here or in individual modules as needed.
buildscript {

    extra["developerGroup"] = "com.newrelic.instrumentation.labs"
    extra["javaAgentVersion"] = "9.0.0"


    repositories {
    flatDir{
        dirs("template-lib")
    }
    mavenLocal()
    mavenCentral()
    gradlePluginPortal()
  }

  dependencies {
      classpath("com.newrelic.agent.java:gradle-verify-instrumentation-plugin:3.2")
      classpath("de.undercouch:gradle-download-task:5.0.0")
  }
}

plugins {
    id("java")
     id("org.jetbrains.kotlin.jvm") version "2.2.21"
}

apply(plugin = "java")
apply(plugin = "de.undercouch.download")

val javaAgentVersion: String = extra["javaAgentVersion"] as String
val developerGroup: String = extra["developerGroup"] as String
val java_version = JavaVersion.VERSION_1_8

tasks.create<Download>("getAgent") {
    val rootDirectory = projectDir.path
    val srcURI = buildString {
        append("https://repo1.maven.org/maven2/com/newrelic/agent/java/newrelic-agent/")
        append(javaAgentVersion)
        append("/newrelic-agent-")
        append(javaAgentVersion)
        append(".jar")
    }
    src(srcURI)
    dest(projectDir.path+"/libs/newrelic-agent-"+javaAgentVersion+".jar")
}

tasks.create<Copy>("extractJars") {

    from(zipTree(projectDir.path+"/libs/newrelic-agent-"+ext.get("javaAgentVersion")+".jar"))
    into(projectDir.path+"/libs")
}

tasks.create<Delete>("cleanUp") {
    delete(projectDir.path+"/libs/META-INF", projectDir.path+"/libs/com", projectDir.path+"/libs/mozilla")
    delete(projectDir.path+"/libs/LICENSE", projectDir.path+"/libs/Log4j-events.dtd", projectDir.path+"/libs/THIRD_PARTY_NOTICES.md")
    delete(fileTree(projectDir.path+"/libs") {
        include("**/*.xsd")
        include("**/*.xml")
        include("**/*.yml")
        include("**/*.properties")
    })
}

tasks.create<Exec>("checkForDependencies") {
    val rootProject = projectDir.path
    val cmdLine = rootProject+"/newrelic-dependencies.sh"
    workingDir(rootProject)
    commandLine(cmdLine)
}




tasks {

    register("buildIfNeeded") {
        dependsOn("checkForDependencies")
        dependsOn("jar")
        findByName("jar")?.mustRunAfter("checkForDependencies")
    }

    register("createModule") {
        dependsOn("checkForDependencies")
        description = "Generate project files for a new instrumentation module"
        group = "New Relic"
        doLast {
            val rootProject: String = projectDir.path
            val developerGroup: String = "com.newrelic.instrumentation.labs"
         
            println("root directory " + rootProject)

            val reader = BufferedReader(InputStreamReader(System.`in`))

            println("Instrumentation Module Group (default: " + developerGroup + ") (Hit return to use default):\n")
            var projectGroup = reader.readLine()
            println("Instrumentation Module Name:\n")
            var projectName = reader.readLine() //System.console()?.readLine("Instrumentation Module Name:\n")

            if (projectName == null) {
                throw Exception("Please specify a valid module name.")
            } else {
                projectName = projectName.trim()
            }

            if (projectGroup == null || projectGroup.trim() == "") {
                projectGroup = developerGroup
            } else {
                projectGroup = projectGroup.trim()
            }

            val projectLibDir = file(rootProject+"/lib")

            val projectPath = file(rootProject + "/" +projectName)
            if (projectPath.exists()) {
                throw Exception(projectPath.path + " already exists.")
            }

            val projectJava = file(projectPath.path + "/src/main/java")
            val projectTest = file(projectPath.path +  "/src/test/java")
            mkdir(projectJava)
            mkdir(projectTest)

            val projectKotlin = file(projectPath.path + "/src/main/kotlin")
            val projectKotlinTest = file(projectPath.path +  "/src/test/kotlin")
            mkdir(projectKotlin)
            mkdir(projectKotlinTest)

            val subProjectBuildFile = file(projectPath.path + "/build.gradle.kts")
            val subprojectTemplate = file(rootProject + "/subproject.template")
            val contents = subprojectTemplate.readText()

            val updatedContents = contents.replace("PROJECT_GROUP", projectGroup).replace("PROJECT_NAME", projectName).replace("PROJECT_PATH", projectPath.path).replace("JAVA_AGENT_VERSION", javaAgentVersion)
            subProjectBuildFile.writeText(updatedContents)

            val settings = file("settings.gradle.kts")
            settings.appendText("include(\""+projectName+"\")\n")
            println("Created module in "+projectPath.path+".")
        }
    }
}



subprojects {
  repositories {
    mavenLocal()
    mavenCentral()
  }

  apply(plugin = "java")
  apply(plugin = "eclipse")
  apply(plugin = "idea")
  apply(plugin = "com.newrelic.gradle-verify-instrumentation-plugin")
  apply(plugin = "org.jetbrains.kotlin.jvm")

  val sourceCompatibility = java_version
  val targetCompatibility = java_version

  dependencies {
    testImplementation(
        fileTree("./libs") {
            include("*.jar")
        }
    )
    testImplementation("org.nanohttpd:nanohttpd:2.3.1")
    testImplementation("com.newrelic.agent.java:newrelic-agent:" + javaAgentVersion)
  }

    tasks {
        create<Copy>("install") {
            dependsOn(rootProject.tasks.named("buildIfNeeded"))
            description ="Copies compiled jar to the NEW_RELIC_EXTENSIONS_DIR."
            group = "New Relic"

            val extDir = System.getenv("NEW_RELIC_EXTENSIONS_DIR") ?: " "

            from(jar)
            into(extDir)

            doFirst  {
                var extDir  = System.getenv("NEW_RELIC_EXTENSIONS_DIR")
                if (extDir == null) {
                    throw Exception("Must set NEW_RELIC_EXTENSIONS_DIR.")
                }

                if (extDir.startsWith("~" + File.separator)) {
                    extDir = System.getProperty("user.home") + extDir.substring(1);
                }

                if (!file(extDir).isDirectory) {
                    throw Exception(extDir + "NEW_RELIC_EXTENSIONS_DIR, set as '" + extDir + "'is not a valid directory.")
                }
            }
        }


    }

  tasks.named<JavaCompile>("compileJava") {
      doFirst {
          tasks.findByName("checkForDependencies")
      }
  }
}
