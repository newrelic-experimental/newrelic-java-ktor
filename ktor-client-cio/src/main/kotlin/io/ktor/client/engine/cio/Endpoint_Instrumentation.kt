package io.ktor.client.engine.cio

import com.newrelic.api.agent.HttpParameters
import com.newrelic.api.agent.NewRelic
import com.newrelic.api.agent.Trace
import com.newrelic.api.agent.weaver.MatchType
import com.newrelic.api.agent.weaver.Weave
import com.newrelic.api.agent.weaver.Weaver
import io.ktor.client.request.HttpRequestData
import java.net.URI

/**
 * Instrumentation for Ktor's CIO Endpoint class.
 *
 * This module instruments the Endpoint.execute method to provide external call
 * tracking for HTTP requests made through Ktor's built-in coroutine-based HTTP implementation.
 *
 * Note: CIO is a pure Kotlin/coroutines implementation with no external HTTP client library,
 * so this Ktor-level instrumentation is essential for visibility.
 *
 * CRITICAL: Uses defensive null checks to prevent NPE issues with Kotlin suspend function
 * bytecode manipulation during Weave instrumentation (see CLAUDE.md best practices).
 */
@Weave(type = MatchType.ExactClass, originalName = "io.ktor.client.engine.cio.Endpoint")
class Endpoint_Instrumentation {

    /**
     * Instruments the execute method to track external HTTP calls.
     *
     * @Trace(leaf = true) prevents this segment from having children, which avoids
     * double-counting if other instrumentation is also present.
     *
     * Note: This is the raw Kotlin suspend function signature after compilation.
     * The data parameter can be null due to bytecode manipulation, hence defensive checks.
     */
    @Trace(leaf = true)
    public fun execute(
        data: HttpRequestData?,  // Nullable because Kotlin suspend function transformation can pass null
        callContext: kotlin.coroutines.CoroutineContext?,
        continuation: kotlin.coroutines.Continuation<io.ktor.client.request.HttpResponseData>?
    ): Any? {
        // Defensive null check and instrumentation (required for Kotlin suspend function Weave instrumentation)
        if (data != null) {
            try {
                // Extract request details
                val url = data.url
                val uri = URI.create(url.toString())
                val method = data.method.toString()

                // Note: DT headers are added at the Sender level in ktor-client-core-2.0
                // before the request reaches the engine

                // Build external parameters
                val params = HttpParameters.library("Ktor-CIO")
                    .uri(uri)
                    .procedure(method)
                    .noInboundHeaders()
                    .build()

                // Report as external call
                NewRelic.getAgent().tracedMethod.reportAsExternal(params)

            } catch (e: Throwable) {
                NewRelic.getAgent().logger.log(
                    java.util.logging.Level.FINER,
                    "Error in Endpoint (CIO) instrumentation: ${e.message}"
                )
            }
        } else {
            NewRelic.getAgent().logger.log(
                java.util.logging.Level.FINER,
                "HttpRequestData is null in Endpoint.execute() - skipping instrumentation"
            )
        }

        // Call original method (only one call allowed)
        return Weaver.callOriginal()
    }
}
