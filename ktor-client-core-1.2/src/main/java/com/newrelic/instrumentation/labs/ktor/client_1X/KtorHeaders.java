package com.newrelic.instrumentation.labs.ktor.client_1X;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.newrelic.api.agent.HeaderType;
import com.newrelic.api.agent.Headers;

import io.ktor.http.HeadersBuilder;

public class KtorHeaders implements Headers {

	private HeadersBuilder builder = null;
	
	public KtorHeaders(HeadersBuilder b) {
		builder = b;
	}
	
	@Override
	public HeaderType getHeaderType() {
		return HeaderType.HTTP;
	}

	@Override
	public String getHeader(String name) {
		return builder.get(name);
	}

	@Override
	public Collection<String> getHeaders(String name) {
		String value = getHeader(name);
		List<String> list = new ArrayList<>();
		if(value != null) {
			list.add(value);
		}
		return list;
	}

	@Override
	public void setHeader(String name, String value) {
		builder.set(name, value);
	}

	@Override
	public void addHeader(String name, String value) {
		builder.append(name, value);
	}

	@Override
	public Collection<String> getHeaderNames() {
		return builder.names();
	}

	@Override
	public boolean containsHeader(String name) {
		return builder.contains(name);
	}

}
