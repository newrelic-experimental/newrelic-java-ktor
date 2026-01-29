package io.ktor.client

import com.newrelic.api.agent.Trace
import com.newrelic.api.agent.weaver.Weaver
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.statement.HttpResponse
import io.ktor.http.Url

@Trace(dispatcher = true)
public suspend inline fun HttpClient.get(url: Url, block: HttpRequestBuilder.() -> Unit = {}): HttpResponse {
    return Weaver.callOriginal()
}
