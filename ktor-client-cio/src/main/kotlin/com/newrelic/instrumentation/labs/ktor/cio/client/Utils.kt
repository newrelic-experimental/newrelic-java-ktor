package com.newrelic.instrumentation.labs.ktor.cio.client

import com.newrelic.api.agent.NewRelic
import io.ktor.client.request.*
import io.ktor.util.*

    @OptIn(InternalAPI::class)
    public fun getUpatedHttpRequestData(request: HttpRequestData): HttpRequestData {
        val nrCIOHeaders = KtorCIOHeaders(request.headers)
        NewRelic.getAgent().transaction.insertDistributedTraceHeaders(nrCIOHeaders)

        return HttpRequestData(
            request.url,
            request.method,
            nrCIOHeaders.updatedHeaders,
            request.body,
            request.executionContext,
            request.attributes
        )
    }
