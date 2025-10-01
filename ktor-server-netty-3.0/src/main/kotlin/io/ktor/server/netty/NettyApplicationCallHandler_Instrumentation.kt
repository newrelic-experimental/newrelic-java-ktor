package io.ktor.server.netty

import com.newrelic.api.agent.NewRelic
import com.newrelic.api.agent.Trace
import com.newrelic.api.agent.TransactionNamePriority
import com.newrelic.api.agent.TransportType
import com.newrelic.api.agent.weaver.Weave
import com.newrelic.api.agent.weaver.Weaver
import com.newrelic.instrumentation.labs.ktor.netty.KtorNettyHeaders
import com.newrelic.labs.instrumentation.ktor.netty.Utils
import io.ktor.server.application.ApplicationCall
import io.ktor.server.application.PipelineCall
import io.ktor.server.routing.RoutingPipelineCall
import io.netty.channel.ChannelHandlerContext
import java.util.logging.Level


@Weave(originalName = "io.ktor.server.netty.NettyApplicationCallHandler")
class NettyApplicationCallHandler_Instrumentation {

    @Trace
    private fun handleRequest(context: ChannelHandlerContext, call: PipelineCall) {
        NewRelic.getAgent().logger.log(Level.FINE, "Call to NettyApplicationCallHandler.handleRequest({0},{1})", context, call)
        val appName = Utils.getApplicationName(call.application)
        if(!appName.isNullOrBlank()) {
            NewRelic.getAgent().tracedMethod.addCustomAttribute("appName", appName)
        }
        val transaction = NewRelic.getAgent().transaction
        if(!transaction.isWebTransaction) {
            transaction.convertToWebTransaction()
        }
        if(call is RoutingPipelineCall) {
            val routeString: String = call.route.toString()
            transaction.setTransactionName(TransactionNamePriority.CUSTOM_LOW, false, "KtorRouting", routeString)
        }
        val request = call.request
        val headers = request.headers
        val ktorNettyHeaders = KtorNettyHeaders(headers)
        transaction.acceptDistributedTraceHeaders(TransportType.HTTP, ktorNettyHeaders)
        val point = request.local
        val txName = Utils.getTransactionName(point)
        if(txName != null && !txName.isEmpty()) {
            transaction.setTransactionName(TransactionNamePriority.CUSTOM_LOW, false, "KtorNetty", txName)
        }
        return Weaver.callOriginal()
    }
}