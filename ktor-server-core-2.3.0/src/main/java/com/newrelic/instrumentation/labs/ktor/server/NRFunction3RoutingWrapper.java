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
import org.jetbrains.annotations.Nullable;

public class NRFunction3RoutingWrapper<A,B,C,D> implements Function3<A,B,C,D> {

	private Function3<A,B,C,D> delegate = null;
	private @Nullable String path = null;
	private @Nullable String method = null;

	private static boolean isTransformed = false;

	public NRFunction3RoutingWrapper( Function3<A, B, C,D> d, @Nullable String path, @Nullable String method) {
		delegate = d;
		this.path = path;
		this.method = method;
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
		if(method != null) {
			String routeString = path != null ? path + " (" + method + ")" : "(" + method + ")";
			routeString = routeString.replace("/(method:", " (");
			if(path != null) {
				NewRelic.getAgent().getTransaction().setTransactionName(TransactionNamePriority.CUSTOM_LOW, true, "Ktor-Server", routeString);
			}
		}
		return delegate.invoke(arg0, arg1, arg2);
	}

}
