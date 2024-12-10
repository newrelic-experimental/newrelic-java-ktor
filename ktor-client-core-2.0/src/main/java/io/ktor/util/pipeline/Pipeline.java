package io.ktor.util.pipeline;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.ktor.client.NRInterceptorWrapper;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;

@Weave(type = MatchType.BaseClass)
public class Pipeline<TSubject, TContext> {
	
	public void intercept(PipelinePhase phase, Function3<? super PipelineContext<TSubject, TContext>, ? super TSubject, ? super Continuation<? super Unit>, ? extends Object> f) {
		NewRelic.getAgent().getTracedMethod().setMetricName(new String[] { "Custom", "Ktor", "Pipeline", getClass().getSimpleName(),phase.getName(), "intercept" });
		NRInterceptorWrapper<? super PipelineContext<TSubject, TContext>, ? super TSubject, ? super Continuation<? super Unit>, ? extends Object>  wrapper = new NRInterceptorWrapper<>(f, this, phase);
		f = wrapper;
		Weaver.callOriginal();
	}	

}
