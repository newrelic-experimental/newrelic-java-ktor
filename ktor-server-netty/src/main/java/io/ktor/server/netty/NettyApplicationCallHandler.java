package io.ktor.server.netty;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TransactionNamePriority;
import com.newrelic.api.agent.TransportType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.labs.instrumentation.ktor.netty.KtorNettyHeaders;
import com.newrelic.labs.instrumentation.ktor.netty.Utils;

import io.ktor.application.ApplicationCall;
import io.ktor.http.Headers;
import io.ktor.http.RequestConnectionPoint;
import io.ktor.request.ApplicationRequest;
import io.netty.channel.ChannelHandlerContext;

@Weave
public class NettyApplicationCallHandler {

	@Trace
	private void handleRequest(ChannelHandlerContext ctx, ApplicationCall call) {
		ApplicationRequest request = call.getRequest();
		if(request != null) {
			Headers headers = request.getHeaders();
			if(headers != null) {
				KtorNettyHeaders nrHeaders = new KtorNettyHeaders(headers);
				NewRelic.getAgent().getTransaction().acceptDistributedTraceHeaders(TransportType.HTTP, nrHeaders);
			}
			RequestConnectionPoint point = request.getLocal();
			String txnName = Utils.getTransactionName(point);
			if(txnName != null && !txnName.isEmpty()) {
				NewRelic.getAgent().getTransaction().setTransactionName(TransactionNamePriority.FRAMEWORK_HIGH, false, "KtorNetty", txnName);
			}
		}
		Weaver.callOriginal();
	}
}
