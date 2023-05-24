package io.ktor.client.plugins;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import kotlin.coroutines.Continuation;

@Weave(type = MatchType.Interface)
public abstract class Sender {

	@Trace(dispatcher = true)
	public Object execute(HttpRequestBuilder builder, Continuation<? super HttpClientCall> continuation) {
		
		return Weaver.callOriginal();
	}
}
