package io.ktor.server.netty

import com.newrelic.api.agent.*
import com.newrelic.api.agent.weaver.Weave
import com.newrelic.api.agent.weaver.Weaver
import com.newrelic.labs.instrumentation.ktor.netty.KtorNettyHeaders
import com.newrelic.labs.instrumentation.ktor.netty.Utils
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.http.Headers
import io.ktor.request.*
import io.netty.channel.ChannelHandlerContext

@Weave(originalName = "io.ktor.server.netty.NettyApplicationCallHandler")
class NettyApplicationCallHandler_Instrumentation {

    @Trace
    private fun handleRequest(context: ChannelHandlerContext, call: ApplicationCall) {
        val transaction : Transaction = NewRelic.getAgent().transaction;
        if(!transaction.isWebTransaction()) {
            transaction.convertToWebTransaction()
        }
        val request : ApplicationRequest? = call.request;
        if(request != null) {
            val headers : Headers? = request.headers;
            if(headers != null) {
                val nrHeaders : KtorNettyHeaders? = KtorNettyHeaders(headers)
                if(nrHeaders != null) {
                    transaction.acceptDistributedTraceHeaders(TransportType.HTTP, nrHeaders)
                }
                val point : RequestConnectionPoint = request.local
                val txnName : String = Utils.getTransactionName(point)
                if(!txnName.isEmpty()) {
                    transaction.setTransactionName(TransactionNamePriority.CUSTOM_LOW, false, "KtorNetty", txnName )
                }
            }
        }
        return Weaver.callOriginal()
    }
}