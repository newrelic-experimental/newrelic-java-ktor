package io.ktor.client.plugins

import com.newrelic.api.agent.HeaderType
import com.newrelic.api.agent.Headers
import com.newrelic.api.agent.NewRelic
import com.newrelic.api.agent.Trace
import com.newrelic.api.agent.weaver.MatchType
import com.newrelic.api.agent.weaver.Weave
import com.newrelic.api.agent.weaver.Weaver
import io.ktor.client.call.HttpClientCall
import io.ktor.client.request.HttpRequestBuilder

@Weave(type = MatchType.Interface, originalName = "io.ktor.client.plugins.Sender")
class Sender_Instrumentation {

    @Trace
    public suspend fun execute(requestBuilder: HttpRequestBuilder): HttpClientCall {
        NewRelic.getAgent().tracedMethod.setMetricName("Custom","Ktor-Client","Sender",this.javaClass.name,"execute")

        // Add Distributed Tracing headers to the mutable request builder
        val headersWrapper = object : Headers {
            override fun getHeaderType(): HeaderType = HeaderType.HTTP

            override fun getHeader(name: String): String? = requestBuilder.headers[name]

            override fun getHeaders(name: String): Collection<String> = requestBuilder.headers.getAll(name) ?: emptyList()

            override fun setHeader(name: String, value: String) {
                requestBuilder.headers.append(name, value)
            }

            override fun addHeader(name: String, value: String) {
                requestBuilder.headers.append(name, value)
            }

            override fun getHeaderNames(): Collection<String> = requestBuilder.headers.names()

            override fun containsHeader(name: String): Boolean = requestBuilder.headers.contains(name)
        }

        // Insert DT headers before the request is sent to the engine
        NewRelic.getAgent().transaction.insertDistributedTraceHeaders(headersWrapper)

        return Weaver.callOriginal()
    }
}