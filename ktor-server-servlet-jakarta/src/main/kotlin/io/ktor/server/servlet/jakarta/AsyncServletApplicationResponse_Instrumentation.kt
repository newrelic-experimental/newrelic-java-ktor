package io.ktor.server.servlet.jakarta

import com.newrelic.api.agent.Trace
import com.newrelic.api.agent.weaver.Weave
import com.newrelic.api.agent.weaver.Weaver
import io.ktor.server.response.ResponsePushBuilder

@Weave(originalName = "io.ktor.server.servlet.jakarta.AsyncServletApplicationResponse")
public open class AsyncServletApplicationResponse_Instrumentation {

    @Trace(dispatcher = true)
    fun push(builder: ResponsePushBuilder) {
        Weaver.callOriginal<Any>()
    }
}