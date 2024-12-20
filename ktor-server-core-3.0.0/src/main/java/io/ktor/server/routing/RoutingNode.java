package io.ktor.server.routing;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.ktor.server.NRFunction2Wrapper;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Weave(type = MatchType.Interface)
public abstract class RoutingNode {
	
	public abstract RouteSelector getSelector();

	@Trace(dispatcher = true)
	public void invoke(Function1<? super RoutingNode,Unit> f) {
		Weaver.callOriginal();
	}

	@Trace
	public void handle(Function2<? super RoutingContext, ? super Continuation<? super Unit>, ? extends Object> f) {
		NRFunction2Wrapper<? super RoutingContext, ? super Continuation<? super Unit>, ? extends Object>  wrapper = new NRFunction2Wrapper<>(f,this);
		f = wrapper;
		Weaver.callOriginal();
	}
	

}
