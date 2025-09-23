package io.ktor.server.netty.http1

import com.newrelic.api.agent.Trace
import com.newrelic.api.agent.weaver.Weave
import com.newrelic.api.agent.weaver.Weaver
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.http.HttpRequest

@Weave(originalName = "io.ktor.server.netty.http1.NettyHttp1Handler")
internal class NettyHttp1Handler_Instrumentation {

    @Trace
    private fun handleRequest(context: ChannelHandlerContext, message: HttpRequest) {
        Weaver.callOriginal<Any>()
    }
}