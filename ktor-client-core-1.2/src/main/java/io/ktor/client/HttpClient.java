package io.ktor.client;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import kotlin.coroutines.Continuation;

@Weave
public class HttpClient {
	
	@Trace(dispatcher = true)
	public final Object execute(HttpRequestBuilder builder, Continuation<? super HttpClientCall> var2) {
		return Weaver.callOriginal();
	}

}
