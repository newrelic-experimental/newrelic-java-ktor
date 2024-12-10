package com.newrelic.instrumentation.ktor.client;

import java.net.URI;

import com.newrelic.api.agent.HttpParameters;

import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.HttpMethod;
import io.ktor.http.URLBuilder;
import io.ktor.http.Url;

public class InstrumentationUtils {

	public static HttpParameters getParams(HttpRequestBuilder builder) {
		URLBuilder urlBuilder = builder.getUrl();
		if(urlBuilder != null) {
			
			Url url = urlBuilder.build();
			URI uri = URI.create(url.toString());
			HttpMethod httpMethod = builder.getMethod();
			return HttpParameters.library("Ktor-Client").uri(uri).procedure(httpMethod.getValue()).noInboundHeaders().build();
		}
		
		return null;
	}
}
