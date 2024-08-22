package io.ktor.client;

import java.util.logging.Level;

import com.newrelic.api.agent.NewRelic;
//import com.newrelic.api.agent.NewRelic;
//import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
//import com.newrelic.api.agent.weaver.Weaver;
//import com.newrelic.instrumentation.ktor.client.KtorHeaders;
//
//import io.ktor.client.call.HttpClientCall;
//import io.ktor.client.request.HttpRequestBuilder;
//import io.ktor.http.HeadersBuilder;
//import kotlin.coroutines.Continuation;
import com.newrelic.api.agent.weaver.WeaveAllConstructors;
import com.newrelic.instrumentation.ktor.client.InstrumentationUtils;

@Weave
public class HttpClient {
	
	@WeaveAllConstructors
	public HttpClient() {
		NewRelic.getAgent().getLogger().log(Level.FINE, "Constructed instance of HttpClient");
		if(!InstrumentationUtils.HTTPCLIENT_INSTRUMENTED) {
			InstrumentationUtils.instrumentHttpClient(this);
		}
	}
	
//	@Trace(dispatcher = true)
//	public final Object execute$ktor_client_core(HttpRequestBuilder builder, Continuation<? super HttpClientCall> var2) {
//		HeadersBuilder headerBuilder = builder.getHeaders();
//		if(headerBuilder != null) {
//			KtorHeaders headers = new KtorHeaders(headerBuilder);
//			NewRelic.getAgent().getTransaction().insertDistributedTraceHeaders(headers);
//		}
//		
//		return Weaver.callOriginal();
//	}

}
