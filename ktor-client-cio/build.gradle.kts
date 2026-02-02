// Build.gradle generated for instrumentation module ktor-client-cio

apply(plugin = "java")

dependencies {
    implementation("io.ktor:ktor-client-cio-jvm:1.4.0")
    // New Relic Java Agent dependencies
    implementation("com.newrelic.agent.java:newrelic-agent:9.0.0")
    implementation("com.newrelic.agent.java:newrelic-api:9.0.0")
    implementation("com.newrelic.agent.java:agent-bridge:9.0.0")
    implementation(fileTree("../test-lib"){
        include("*.jar")
    })
}

tasks.jar {
    manifest {
        attributes(
            "Implementation-Title" to "com.newrelic.instrumentation.labs.ktor-client-cio",
            "Implementation-Vendor" to "New Relic Labs",
            "Implementation-Vendor-Id" to "com.newrelic.labs",
            "Implementation-Version" to 1.0
        )
    }
}

verifyInstrumentation {
    passes("io.ktor:ktor-client-cio-jvm:[1.4.0,)")
}
