package io.ktor.util.pipeline;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.ktor.server.KtorExtendedRequest;
import com.newrelic.instrumentation.labs.ktor.server.KtorExtendedResponse;

import io.ktor.application.ApplicationCall;
import io.ktor.request.ApplicationReceivePipeline;
import io.ktor.response.ApplicationSendPipeline;
import kotlin.coroutines.Continuation;

@Weave(type = MatchType.BaseClass)
public class Pipeline<TSubject, TContext> {

	@Trace(dispatcher = true)
	public Object execute(TContext context, TSubject subject, Continuation<? super TSubject> var3) {
		NewRelic.getAgent().getTracedMethod().setMetricName(new String[] { "Custom", "Ktor", "Pipeline", getClass().getSimpleName(), "execute" });
		if (this instanceof ApplicationReceivePipeline) {
			ApplicationCall call = (ApplicationCall)context;
			NewRelic.getAgent().getTransaction().setWebRequest(new KtorExtendedRequest(call));
		} else if (this instanceof ApplicationSendPipeline) {
			ApplicationCall call = (ApplicationCall)context;
			NewRelic.getAgent().getTransaction().setWebResponse(new KtorExtendedResponse(call));
		} 
		return Weaver.callOriginal();
	}	

}
