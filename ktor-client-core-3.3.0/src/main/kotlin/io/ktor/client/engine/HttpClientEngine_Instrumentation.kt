package io.ktor.client.engine

import com.newrelic.api.agent.NewRelic
import com.newrelic.api.agent.Token
import com.newrelic.api.agent.Trace
import com.newrelic.api.agent.weaver.MatchType
import com.newrelic.api.agent.weaver.Weave
import com.newrelic.api.agent.weaver.Weaver
import com.newrelic.instrumentation.labs.ktor.client.InstrumentationUtils
import io.ktor.client.request.HttpRequestData
import io.ktor.client.request.HttpResponseData
import kotlinx.coroutines.CoroutineScope
import kotlin.coroutines.coroutineContext

/**
 * Interface-level instrumentation for Ktor HTTP client engines.
 *
 * This instrumentation provides custom metrics showing which engine is being used.
 * External call reporting is handled by engine-specific modules:
 * - ktor-client-jetty-2.0 for Jetty engine
 * - ktor-client-cio-2.0 for CIO engine
 * - New Relic's library instrumentation for OkHttp, Apache5, Java engines
 *
 * Note: Does NOT report external calls to avoid double-counting.
 */
@Weave(type = MatchType.Interface, originalName = "io.ktor.client.engine.HttpClientEngine")
abstract class HttpClientEngine_Instrumentation : CoroutineScope {

    /**
     * Instruments the execute method to track Ktor client engine usage.
     *
     * @Trace (without leaf=true) allows child segments from engine-specific instrumentation
     * or New Relic's library instrumentation.
     */
    @Trace
    public suspend fun execute(data: HttpRequestData): HttpResponseData {
        // Get the actual engine implementation class name
        val engineName = this.javaClass.simpleName

        // Record custom metric to show which engine is being used
        // This provides visibility into engine usage patterns
        NewRelic.getAgent().tracedMethod.setMetricName(
            "Custom", "Ktor-Client", engineName, "execute"
        )

        // Do NOT report as external call here
        // External reporting is handled by:
        // - ktor-client-jetty-2.0 (for Jetty)
        // - ktor-client-cio-2.0 (for CIO)
        // - New Relic's library modules (for OkHttp, Apache5, Java)

        return Weaver.callOriginal()
    }
}

/**
 * Instruments the internal framework method that wraps execute().
 * Provides visibility into the Ktor framework call stack.
 */
@Trace(dispatcher = true)
private suspend fun executeWithinCallContext(requestData: HttpRequestData): HttpResponseData {
//    var token : Token? = InstrumentationUtils.getToken(coroutineContext);
//    if(token != null) {
//        token.link();
//        InstrumentationUtils.expireToken(coroutineContext);
//        token = null;
//    }
    NewRelic.getAgent().tracedMethod.setMetricName(
        "Custom", "Ktor-Client", "HttpClientEngine", "executeWithinCallContext"
    )
    // Do NOT report as external - let execute() method handle it
    return Weaver.callOriginal()
}
