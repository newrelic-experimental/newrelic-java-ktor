package io.ktor.client.plugins;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.WeaveAllConstructors;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.ktor.client.InstrumentationUtils;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import kotlin.coroutines.Continuation;

@Weave
public class HttpSend {

	@Weave
	private static class DefaultSender {
		
		@WeaveAllConstructors
		public DefaultSender() {
			if(!InstrumentationUtils.HTTPSENDER_INSTRUMENTED) {
				InstrumentationUtils.instrumentDefaultSender(getClass());
			}
		}
	}
	
	@Weave
	private static class InterceptedSender {
		
		@Trace
		public Object execute(HttpRequestBuilder requestBuilder, Continuation<? super HttpClientCall> call) {
			return Weaver.callOriginal();
		}

	}
}
