package com.newrelic.labs.instrumentation.ktor.netty;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.newrelic.api.agent.HeaderType;
import com.newrelic.api.agent.Headers;

public class KtorNettyHeaders implements Headers {
	
	io.ktor.http.Headers ktorHeaders = null;
	
	public KtorNettyHeaders(io.ktor.http.Headers kh) {
		ktorHeaders = kh;
	}

	@Override
	public HeaderType getHeaderType() {
		return HeaderType.HTTP;
	}

	@Override
	public String getHeader(String name) {
		return ktorHeaders.get(name);
	}

	@Override
	public Collection<String> getHeaders(String name) {
		List<String> list = ktorHeaders.getAll(name);
		
		return list != null ? list : Collections.emptyList();
	}

	@Override
	public void setHeader(String name, String value) {
		
	}

	@Override
	public void addHeader(String name, String value) {

	}

	@Override
	public Collection<String> getHeaderNames() {
		return ktorHeaders.names();
	}

	@Override
	public boolean containsHeader(String name) {
		return ktorHeaders.contains(name);
	}

}
