package com.newrelic.instrumentation.labs.ktor.server;

import com.newrelic.agent.bridge.AgentBridge;
import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TracedMethod;
import com.newrelic.api.agent.Transaction;
import com.newrelic.api.agent.TransactionNamePriority;

import io.ktor.server.routing.Route;
import io.ktor.server.routing.RouteSelector;
import kotlin.jvm.functions.Function3;

public class NRFunction3Wrapper<A,B,C,D> implements Function3<A,B,C,D> {
	
	private Function3<A,B,C,D> delegate = null;
	private Route route = null;
	private static boolean isTransformed = false;
		
	public NRFunction3Wrapper( Function3<A, B, C,D> d, Route r) {
		delegate = d;
		route = r;
		if(!isTransformed) {
			AgentBridge.instrumentation.retransformUninstrumentedClass(getClass());
			isTransformed = true;
		}
	}

	@Override
	@Trace(dispatcher = true)
	public D invoke(A arg0, B arg1, C arg2) {
		Transaction transaction = NewRelic.getAgent().getTransaction();
		if(!transaction.isWebTransaction()) {
			transaction.convertToWebTransaction();
		}
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		if(route != null) {
			String routeString = route.toString();
			if(routeString != null && !routeString.isEmpty()) {
				routeString = routeString.replace("/(method:", " (");
				NewRelic.getAgent().getTransaction().setTransactionName(TransactionNamePriority.CUSTOM_LOW, true, "Ktor-Server", routeString);
			}
		}
		RouteSelector selector = route != null ? route.getSelector() : null;
		if(selector != null) {
			traced.addCustomAttribute("Selector", selector.toString());
			traced.addCustomAttribute("Selector-Class", selector.getClass().toString());
		}
		
		return delegate.invoke(arg0, arg1, arg2);
	}

}
