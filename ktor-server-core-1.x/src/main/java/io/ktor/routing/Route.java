package io.ktor.routing;

import java.util.List;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import io.ktor.application.ApplicationCall;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

@Weave
public abstract class Route {

	@Trace
	public void invoke(Function1<? super Route,Unit> f) {
		Weaver.callOriginal();
	}

	@Trace
	public void handle(Function3<? super PipelineContext<Unit, ApplicationCall>, ? super Unit, ? super Continuation<? super Unit>, ? extends Object> f) {
		Weaver.callOriginal();
	}

	public abstract RouteSelector getSelector();
	public abstract Route getParent();
	public abstract List<Route> getChildren();

}
