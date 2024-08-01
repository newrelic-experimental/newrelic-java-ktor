package io.ktor.server.netty;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.Transaction;
import com.newrelic.api.agent.TransactionNamePriority;
import com.newrelic.api.agent.TransportType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.labs.instrumentation.ktor.netty.KtorNettyHeaders;
import com.newrelic.labs.instrumentation.ktor.netty.Utils;

import io.ktor.http.Headers;
import io.ktor.http.RequestConnectionPoint;
import io.ktor.server.application.ApplicationCall;
import io.ktor.server.request.ApplicationRequest;
import io.netty.channel.ChannelHandlerContext;

@Weave
public class NettyApplicationCallHandler {

	@Trace
	private void handleRequest(ChannelHandlerContext ctx, ApplicationCall call) {
		Transaction transaction = NewRelic.getAgent().getTransaction();
		if(!transaction.isWebTransaction()) {
			transaction.convertToWebTransaction();
		}
		ApplicationRequest request = call.getRequest();
		if(request != null) {
			Headers headers = request.getHeaders();
			if(headers != null) {
				KtorNettyHeaders nrHeaders = new KtorNettyHeaders(headers);
				transaction.acceptDistributedTraceHeaders(TransportType.HTTP, nrHeaders);
			}
			RequestConnectionPoint point = request.getLocal();
			String txnName = Utils.getTransactionName(point);
			if(txnName != null && !txnName.isEmpty()) {
				transaction.setTransactionName(TransactionNamePriority.CUSTOM_LOW, false, "KtorNetty", txnName);
			}
		}
		Weaver.callOriginal();
	}
}
