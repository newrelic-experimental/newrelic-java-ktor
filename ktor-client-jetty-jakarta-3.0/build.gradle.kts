// Build.gradle for instrumentation module ktor-client-jetty-jakarta-3.0

apply(plugin = "java")

dependencies {
    implementation("io.ktor:ktor-client-jetty-jakarta-jvm:3.0.0")

    // New Relic Java Agent dependencies
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
        attributes (
            "Implementation-Title" to "com.newrelic.instrumentation.labs.ktor-client-jetty-jakarta-3.0",
            "Implementation-Vendor" to  "New Relic Labs",
            "Implementation-Vendor-Id" to  "com.newrelic.labs",
            "Implementation-Version" to  1.0)
    }
}

verifyInstrumentation {
    passesOnly("io.ktor:ktor-client-jetty-jakarta-jvm:[2.3.0,)")
    excludeRegex(".*beta.*")
    excludeRegex(".*rc.*")
}
