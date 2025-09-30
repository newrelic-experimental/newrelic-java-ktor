package com.newrelic.instrumentation.labs.ktor.netty

import com.newrelic.api.agent.HeaderType
import com.newrelic.api.agent.Headers
import java.util.Collections

class KtorNettyHeaders(private val ktorHeaders: io.ktor.http.Headers) : Headers {


    override fun getHeaderType(): HeaderType? {
        return HeaderType.HTTP
    }

    override fun getHeader(name: String): String? {
        val value = ktorHeaders.get(name)
        return value
    }

    override fun getHeaders(name: String): Collection<String?>? {
        val values = ktorHeaders.getAll(name)
        if (values != null) {
            return values
        } else {
            return Collections.emptyList()
        }
    }

    override fun setHeader(p0: String?, p1: String?) {
    }

    override fun addHeader(p0: String?, p1: String?) {
    }

    override fun getHeaderNames(): Collection<String?>? {
       return ktorHeaders.names()
    }

    override fun containsHeader(name: String): Boolean {
        return ktorHeaders.contains(name)
    }
}