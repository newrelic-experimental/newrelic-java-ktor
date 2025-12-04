package io.ktor.client.engine.cio

import com.newrelic.api.agent.HttpParameters
import com.newrelic.api.agent.NewRelic
import com.newrelic.api.agent.Trace
import com.newrelic.api.agent.weaver.MatchType
import com.newrelic.api.agent.weaver.Weave
import com.newrelic.api.agent.weaver.Weaver
import io.ktor.client.request.HttpRequestData
import io.ktor.client.request.HttpResponseData
import java.net.URI

/**
 * Instrumentation for Ktor's CIO (Coroutine I/O) client engine.
 *
 * This module instruments the CIOEngine class to provide external call
 * tracking for HTTP requests made through Ktor's built-in coroutine-based HTTP implementation.
 *
 * Note: CIO is a pure Kotlin/coroutines implementation with no external HTTP client library,
 * so this Ktor-level instrumentation is essential for visibility.
 */
@Weave(type = MatchType.ExactClass, originalName = "io.ktor.client.engine.cio.CIOEngine")
internal class CIOEngine_Instrumentation {

    /**
     * Instruments the execute method to track external HTTP calls.
     *
     * @Trace(leaf = true) prevents this segment from having children, which avoids
     * double-counting if the interface-level instrumentation is also present.
     */
    @Trace(leaf = true)
    public suspend fun execute(data: HttpRequestData): HttpResponseData {
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

        // Call original method
        return Weaver.callOriginal()
    }
}
