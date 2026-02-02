// Build.gradle generated for instrumentation module ktor-server-servlet-jakarta

apply(plugin = "java")

dependencies {
   implementation("io.ktor:ktor-server-servlet-jakarta-jvm:3.0.0")
   compileOnly("jakarta.servlet:jakarta.servlet-api:5.0.0")

   implementation("com.newrelic.agent.java:newrelic-api:8.4.0")
   implementation("com.newrelic.agent.java:newrelic-agent:8.4.0")
   implementation("com.newrelic.agent.java:newrelic-weaver-api:8.4.0")
   implementation("com.newrelic.agent.java:agent-bridge:8.4.0")
    implementation(fileTree("../test-lib"){
        include("*.jar")
    })

}

tasks.jar {
  manifest {
    attributes(
        "Implementation-Title" to "com.newrelic.instrumentation.labs.ktor-server-servlet-jakarta",
        "Implementation-Vendor" to  "New Relic Labs",
        "Implementation-Vendor-Id" to  "com.newrelic.labs",
        "Implementation-Version" to  1.0
    )
  }
}

verifyInstrumentation {
    passesOnly("io.ktor:ktor-server-servlet-jakarta-jvm:[3.0.0,)") {
        compile("jakarta.servlet:jakarta.servlet-api:5.0.0")
    }
    excludeRegex(".*rc.*")
    excludeRegex(".*beta.*")
}

