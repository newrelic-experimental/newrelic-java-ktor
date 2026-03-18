package com.newrelic.instrumentation.labs.ktor.cio.client;

import com.newrelic.api.agent.HeaderType;
import com.newrelic.api.agent.Headers;
import com.newrelic.api.agent.NewRelic;
import io.ktor.http.HeadersBuilder;

import java.util.*;
import java.util.logging.Level;

public class KtorCIOHeaders implements Headers {


    private io.ktor.http.Headers headers;
    public KtorCIOHeaders(io.ktor.http.Headers headers) {
        this.headers = headers;
    }

    @Override
    public HeaderType getHeaderType() {
        return HeaderType.HTTP;
    }

    @Override
    public String getHeader(String name) {
        return headers.get(name);
    }

    @Override
    public Collection<String> getHeaders(String name) {
        return headers.getAll(name);
    }

    @Override
    public void setHeader(String name, String value) {
        NewRelic.getAgent().getLogger().log(Level.FINE,"Call to KtorCIOHeaders set header - name {0}, value {1}", name, value);
        HeadersBuilder headersBuilder = new HeadersBuilder();
        Set<Map.Entry<String, List<String>>> entries = headers.entries();
        for (Map.Entry<String, List<String>> entry : entries) {
            String key = entry.getKey();
            List<String> values = entry.getValue();
            headersBuilder.appendAll(key, values);
        }
        headersBuilder.set(name, value);
        headers = headersBuilder.build();

    }

    @Override
    public void addHeader(String name, String value) {
        NewRelic.getAgent().getLogger().log(Level.FINE,"Call to KtorCIOHeaders add header - name {0}, value {1}", name, value);
        HeadersBuilder headersBuilder = new HeadersBuilder();
        Set<Map.Entry<String, List<String>>> entries = headers.entries();
        for (Map.Entry<String, List<String>> entry : entries) {
            String key = entry.getKey();
            List<String> values = entry.getValue();
            headersBuilder.appendAll(key, values);
        }
        headersBuilder.append(name, value);
        headers = headersBuilder.build();

    }

    @Override
    public Collection<String> getHeaderNames() {
        return headers.names();
    }

    @Override
    public boolean containsHeader(String name) {
        return headers.contains(name);
    }

    public io.ktor.http.Headers getUpdatedHeaders() {
        return headers;
    }
}
