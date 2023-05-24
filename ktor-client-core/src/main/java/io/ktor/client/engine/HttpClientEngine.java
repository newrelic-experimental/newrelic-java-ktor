package io.ktor.client.engine;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.call.HttpEngineCall;
import io.ktor.client.request.HttpRequestData;
import kotlin.coroutines.Continuation;

@Weave(type = MatchType.Interface)
public abstract class HttpClientEngine {

	@Trace(dispatcher = true)
	public Object execute(HttpClientCall var1, HttpRequestData var2, Continuation<? super HttpEngineCall> var3) {
		return Weaver.callOriginal();
}
}
