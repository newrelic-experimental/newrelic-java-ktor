<<<<<<<< HEAD:ktor-client-cio-3.2.0/build.gradle.kts
// Build.gradle generated for instrumentation module ktor-client-cio
========
// Build.gradle generated for instrumentation module ktor-ignores-setup
>>>>>>>> main:ktor-ignores-setup/build.gradle.kts

apply(plugin = "java")

dependencies {
<<<<<<<< HEAD:ktor-client-cio-3.2.0/build.gradle.kts
    implementation("io.ktor:ktor-client-cio-jvm:3.2.0")
========

>>>>>>>> main:ktor-ignores-setup/build.gradle.kts
    // New Relic Java Agent dependencies
    implementation("com.newrelic.agent.java:newrelic-agent:9.1.0")
    implementation("com.newrelic.agent.java:newrelic-api:9.1.0")
    implementation("com.newrelic.agent.java:agent-bridge:9.1.0")
    implementation(fileTree("../test-lib") {
        include("*.jar")
    })
}

tasks.jar {
    manifest {
        attributes(
<<<<<<<< HEAD:ktor-client-cio-3.2.0/build.gradle.kts
            "Implementation-Title" to "com.newrelic.instrumentation.labs.ktor-client-cio-3.2.0",
            "Implementation-Vendor" to "New Relic Labs",
            "Implementation-Vendor-Id" to "com.newrelic.labs",
            "Implementation-Version" to 1.0
========
            "Implementation-Title" to "com.newrelic.instrumentation.labs.ktor-ignores-setup",
            "Implementation-Vendor" to "New Relic Labs",
            "Implementation-Vendor-Id" to "com.newrelic.labs",
            "Implementation-Version" to 1.0,
            "Agent-Class" to "com.newrelic.instrumentation.labs.ktor.ignores.KtorSetupPremain"
>>>>>>>> main:ktor-ignores-setup/build.gradle.kts
        )
    }
}

verifyInstrumentation {
    passesOnly("io.ktor:ktor-client-cio-jvm:[3.2.0,)")
}
