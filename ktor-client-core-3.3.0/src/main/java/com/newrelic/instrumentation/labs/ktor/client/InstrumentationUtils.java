package com.newrelic.instrumentation.labs.ktor.client;

import java.net.URI;

import com.newrelic.api.agent.HttpParameters;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Token;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.HttpMethod;
import io.ktor.http.URLBuilder;
import io.ktor.http.Url;
import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.Nullable;

public class InstrumentationUtils {

	public static HttpParameters getParams(HttpRequestBuilder builder) {
		URLBuilder urlBuilder = builder.getUrl();
		if (urlBuilder != null) {

			Url url = urlBuilder.build();
			URI uri = URI.create(url.toString());
			HttpMethod httpMethod = builder.getMethod();
			return HttpParameters.library("Ktor-Client").uri(uri).procedure(httpMethod.getValue()).noInboundHeaders().build();
		}

		return null;
	}

	public static void setToken(CoroutineContext context) {
		TokenContext tokenContext = NRTokenContextKt.getTokenContext(context);;
		if (tokenContext == null) {
			Token t = NewRelic.getAgent().getTransaction().getToken();
			if(t != null && t.isActive()) {
				NRTokenContextKt.addTokenContext(context,t);
			} else if(t != null) {
				t.expire();
				t = null;
			}
		}
	}

	public static Token getToken(CoroutineContext context) {
		TokenContext tokenContext = NRTokenContextKt.getTokenContext(context);
		if (tokenContext != null) {
			return tokenContext.getToken();
		}
		return null;
	}

	public static void expireToken(CoroutineContext context) {
		@Nullable TokenContext tokencontext = NRTokenContextKt.getTokenContextOrNull(context);
		if (tokencontext != null) {
			Token token = tokencontext.getToken();
			token.expire();
			token =	null;
			NRTokenContextKt.removeTokenContext(context);
		}
	}
}
