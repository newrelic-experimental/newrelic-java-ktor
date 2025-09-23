package io.ktor.server.netty.cio

import com.newrelic.api.agent.NewRelic
import com.newrelic.api.agent.Trace
import com.newrelic.api.agent.weaver.Weave
import com.newrelic.api.agent.weaver.Weaver
import com.newrelic.labs.instrumentation.ktor.netty.Utils
import io.ktor.server.netty.NettyApplicationCall

@Weave(originalName = "io.ktor.server.netty.cio.NettyRequestQueue")
class NettyRequestQueue_Instrumentation {

    @Trace
    fun schedule(call: NettyApplicationCall) {
        val application = call.application
        val appName = Utils.getApplicationName(application)
        NewRelic.getAgent().tracedMethod.addCustomAttribute("Application", appName)
        Weaver.callOriginal<Any>()
    }
}