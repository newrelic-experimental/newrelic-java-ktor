package io.ktor.client.plugins

import com.newrelic.api.agent.NewRelic
import com.newrelic.api.agent.Trace
import com.newrelic.api.agent.weaver.MatchType
import com.newrelic.api.agent.weaver.Weave
import com.newrelic.api.agent.weaver.Weaver
import com.newrelic.instrumentation.labs.ktor.client.InstrumentationUtils
import com.newrelic.instrumentation.labs.ktor.client.KtorHeaderWrapper
import io.ktor.client.call.*
import io.ktor.client.request.*

@Weave(type = MatchType.Interface, originalName = "io.ktor.client.plugins.Sender")
class Sender_Instrumentation {

    @Trace
    public suspend fun execute(requestBuilder: HttpRequestBuilder): HttpClientCall {
        if (!InstrumentationUtils.initialized) {
            InstrumentationUtils.init()
        }
        NewRelic.getAgent().tracedMethod.setMetricName("Custom","Ktor-Client","Sender",this.javaClass.name,"execute")

        // in spite of what IntelliJ says this can be null
        if (requestBuilder != null) {
            // Add Distributed Tracing headers to the mutable request builder
            val headersWrapper = KtorHeaderWrapper(requestBuilder.headers)

            // Insert DT headers before the request is sent to the engine
            NewRelic.getAgent().transaction.insertDistributedTraceHeaders(headersWrapper)
        }

        return Weaver.callOriginal()
    }
}