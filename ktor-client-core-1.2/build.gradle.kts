// Build.gradle generated for instrumentation module ktor-client-core

apply(plugin = "java")

dependencies {
    implementation("io.ktor:ktor-client-core-jvm:1.2.0")

    // New Relic Java Agent dependencies
    implementation("com.newrelic.agent.java:newrelic-api:9.1.0")
    implementation("com.newrelic.agent.java:newrelic-agent:9.1.0")
    implementation("com.newrelic.agent.java:newrelic-weaver-api:9.1.0")
    implementation("com.newrelic.agent.java:agent-bridge:9.1.0")
    implementation(fileTree("../test-lib") {
        include("*.jar")
    })
}

tasks.jar {
    manifest {
        attributes(
            "Implementation-Title" to "com.newrelic.instrumentation.labs.ktor-client-core-1.2",
            "Implementation-Vendor" to "New Relic Labs",
            "Implementation-Vendor-Id" to "com.newrelic.labs",
            "Implementation-Version" to 1.0
        )
    }
}

verifyInstrumentation {
    passes("io.ktor:ktor-client-core-jvm:[1.2.0,2.0.0)")
    excludeRegex(".*rc-[0-9]")
    excludeRegex(".*beta-[0-9]")
}
