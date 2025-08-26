package io.ktor.client

import com.newrelic.api.agent.NewRelic
import com.newrelic.api.agent.Trace
import com.newrelic.api.agent.weaver.Weave
import com.newrelic.api.agent.weaver.Weaver
import com.newrelic.instrumentation.labs.ktor.client_1X.KtorHeaders
import io.ktor.client.call.HttpClientCall
import io.ktor.client.request.HttpRequestBuilder

@Weave(originalName = "io.ktor.client.HttpClient")
public class HttpClient_Instrumentation {

    @Trace(dispatcher = true)
    suspend fun execute(builder: HttpRequestBuilder): HttpClientCall {
        val headers = KtorHeaders(builder.headers)
        NewRelic.getAgent().transaction.insertDistributedTraceHeaders(headers)
        return Weaver.callOriginal()
    }
}