package io.ktor.client.engine;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpResponseData;
import kotlin.coroutines.Continuation;

@Weave(type = MatchType.Interface)
public abstract class HttpClientEngine {

	@Trace(dispatcher = true)
	public Object execute(HttpRequestData var2, Continuation<? super HttpResponseData> var3) {
		return Weaver.callOriginal();
}
}
