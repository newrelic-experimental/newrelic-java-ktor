package io.ktor.client.engine;

import com.newrelic.api.agent.Trace;
//import java.net.URI;
//import java.net.URL;
//
//import com.newrelic.api.agent.HttpParameters;
//import com.newrelic.api.agent.NewRelic;
//import com.newrelic.api.agent.Trace;
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

	@Weave
	public static class DefaultImpls {
		
//		@Trace(dispatcher = true)
//		private static Object executeWithinCallContext(final HttpClientEngine var0, final HttpRequestData requestData, Continuation<? super HttpResponseData> var2) {
//			 Url url = requestData.getUrl();
//			URI uri = URI.create(url.toString());
//			HttpParameters params = HttpParameters.library("Ktor-Client").uri(uri).procedure("").noInboundHeaders().build();
//			NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
//			return Weaver.callOriginal();
//		}
	}
}
