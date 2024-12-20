package com.newrelic.instrumentation.labs.ktor.server;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TracedMethod;
import com.newrelic.api.agent.Transaction;
import com.newrelic.api.agent.TransactionNamePriority;

import io.ktor.server.routing.RouteSelector;
import io.ktor.server.routing.RoutingNode;
import kotlin.jvm.functions.Function2;

public class NRFunction2Wrapper<A, B, C> implements Function2<A, B, C> {

	private Function2<A, B, C> delegate = null;
	private RoutingNode routing = null;
	
	public NRFunction2Wrapper(Function2<A, B, C> f, RoutingNode r) {
		delegate = f;
		routing = r;
	}
	
	@Override
	@Trace(dispatcher = true)
	public C invoke(A arg0, B arg1) {
		Transaction transaction = NewRelic.getAgent().getTransaction();
		if(!transaction.isWebTransaction()) {
			transaction.convertToWebTransaction();
		}
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		if(routing != null) {
			String routeString = routing.toString();
			if(routeString != null && !routeString.isEmpty()) {
				routeString = routeString.replace("/(method:", " (");
				NewRelic.getAgent().getTransaction().setTransactionName(TransactionNamePriority.CUSTOM_LOW, true, "Ktor-Server", routeString);
			}
		}
		RouteSelector selector = routing != null ? routing.getSelector() : null;
		if(selector != null) {
			traced.addCustomAttribute("Selector", selector.toString());
			traced.addCustomAttribute("Selector-Class", selector.getClass().toString());
		}
		return delegate.invoke(arg0, arg1);
	}

}
