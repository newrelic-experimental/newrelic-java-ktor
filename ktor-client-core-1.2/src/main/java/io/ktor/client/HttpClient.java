package io.ktor.client;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.ktor.client_1X.KtorHeaders;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import kotlin.coroutines.Continuation;

@Weave
public class HttpClient {
	
	@Trace(dispatcher = true)
	public final Object execute(HttpRequestBuilder builder, Continuation<? super HttpClientCall> var2) {
		KtorHeaders headers = new KtorHeaders(builder.getHeaders());
		NewRelic.getAgent().getTransaction().insertDistributedTraceHeaders(headers);
		return Weaver.callOriginal();
	}

}
