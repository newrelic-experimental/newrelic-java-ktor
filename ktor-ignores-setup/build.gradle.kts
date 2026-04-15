// Build.gradle generated for instrumentation module ktor-ignores-setup

apply(plugin = "java")

dependencies {

    // New Relic Java Agent dependencies
    implementation("com.newrelic.agent.java:newrelic-agent:9.1.0")
    implementation("com.newrelic.agent.java:newrelic-api:9.1.0")
    implementation(fileTree("../test-lib"){
        include("*.jar")
    })
}

tasks.jar {
    manifest {
        attributes(
            "Implementation-Title" to "com.newrelic.instrumentation.labs.ktor-ignores-setup",
            "Implementation-Vendor" to "New Relic Labs",
            "Implementation-Vendor-Id" to "com.newrelic.labs",
            "Implementation-Version" to 1.0,
            "Agent-Class" to "com.newrelic.instrumentation.labs.ktor.ignores.KtorSetupPremain"
        )
    }
}

verifyInstrumentation {
}
