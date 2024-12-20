package io.ktor.client;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import kotlin.coroutines.Continuation;

@Weave
public abstract class HttpClient {
	
	@Trace(dispatcher = true)
	public Object execute$ktor_client_core(HttpRequestBuilder builder, Continuation<? super HttpClientCall> cont) {
		return Weaver.callOriginal();
	}
}
