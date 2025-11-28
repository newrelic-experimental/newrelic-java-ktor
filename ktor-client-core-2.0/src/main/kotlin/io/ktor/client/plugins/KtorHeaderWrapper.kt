package io.ktor.client.plugins

import com.newrelic.api.agent.HeaderType
import com.newrelic.api.agent.Headers
import io.ktor.http.HeadersBuilder

/**
 * Wrapper class that adapts Ktor's HeadersBuilder to New Relic's Headers interface
 * for distributed tracing header insertion.
 */
class KtorHeaderWrapper(private val headersBuilder: HeadersBuilder) : Headers {

    override fun getHeaderType(): HeaderType = HeaderType.HTTP

    override fun getHeader(name: String): String? = headersBuilder[name]

    override fun getHeaders(name: String): Collection<String> =
        headersBuilder.getAll(name) ?: emptyList()

    override fun setHeader(name: String, value: String) {
        headersBuilder.append(name, value)
    }

    override fun addHeader(name: String, value: String) {
        headersBuilder.append(name, value)
    }

    override fun getHeaderNames(): Collection<String> = headersBuilder.names()

    override fun containsHeader(name: String): Boolean = headersBuilder.contains(name)
}
