package io.ktor.util.pipeline;

import com.newrelic.api.agent.HttpParameters;
import com.newrelic.api.agent.Segment;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.NewField;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import kotlin.coroutines.Continuation;

@Weave(type = MatchType.BaseClass)
public abstract class PipelineContext<TSubject, TContext> {
	
	@NewField
	public Segment httpCallSegment = null;
	
	@NewField 
	public HttpParameters params = null;
	
	public PipelineContext(TContext ctx) {
		
	}

	@Trace
	public Object proceedWith(TSubject subject, Continuation<? super TSubject> cont) {
		return Weaver.callOriginal();
	}

	@Trace
	public Object proceed(Continuation<? super TSubject> cont) {
		return Weaver.callOriginal();
	}
	
	@Trace
	public void finish() {
		if(httpCallSegment != null) {
			
		}
		Weaver.callOriginal();
	}
	
	public abstract TContext getContext();
	public abstract TSubject getSubject();
	
}
