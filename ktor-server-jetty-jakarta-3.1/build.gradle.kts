
// Build.gradle generated for instrumentation module ktor-server-jetty-jakarta-3.0

apply(plugin = "java")

dependencies {
    implementation("io.ktor:ktor-server-jetty-jakarta-jvm:3.1.0")

    // New Relic Java Agent dependencies
    implementation("com.newrelic.agent.java:newrelic-agent:8.4.0")
    implementation("com.newrelic.agent.java:newrelic-api:8.4.0")
    implementation("com.newrelic.agent.java:newrelic-weaver-api:8.4.0")
    implementation("com.newrelic.agent.java:agent-bridge:8.4.0")
    implementation(fileTree("../test-lib"){
        include("*.jar")
    })

   
   // Jakarta Servlet API for compilation
   compileOnly("jakarta.servlet:jakarta.servlet-api:6.0.0")
}

tasks.jar {
  manifest {
    attributes(
        "Implementation-Title" to "com.newrelic.instrumentation.labs.ktor-server-jetty-jakarta-3.1",
        "Implementation-Vendor" to  "New Relic Labs",
        "Implementation-Vendor-Id" to  "com.newrelic.labs",
        "Implementation-Version" to  1.0
    )
  }
}

verifyInstrumentation {
  // Verifier plugin documentation:
  // https://github.com/newrelic/newrelic-gradle-verify-instrumentation
  // Verify against the Jakarta servlet version of Ktor Jetty 3.1
  passes("io.ktor:ktor-server-jetty-jakarta-jvm:[3.1.0,3.3.0)")
  excludeRegex("io.ktor:ktor-server-jetty-jakarta-jvm:*-beta*")
  excludeRegex("io.ktor:ktor-server-jetty-jakarta-jvm:*-rc*")
}
