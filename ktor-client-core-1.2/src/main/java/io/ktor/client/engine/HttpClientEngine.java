package io.ktor.client.engine;

import java.net.URI;

import com.newrelic.api.agent.HttpParameters;
import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpResponseData;
import io.ktor.http.Url;
import kotlin.coroutines.Continuation;

@Weave(type = MatchType.Interface)
public abstract class HttpClientEngine {

	@Trace(dispatcher = true)
	public Object execute(HttpRequestData var2, Continuation<? super HttpResponseData> var3) {
		Url url = var2.getUrl();
		URI uri = URI.create(url.toString());
		String proc = var2.getMethod().getValue();
		HttpParameters params = HttpParameters.library("Ktor-Client").uri(uri).procedure(proc).noInboundHeaders().build();
		NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
		return Weaver.callOriginal();
}
}
