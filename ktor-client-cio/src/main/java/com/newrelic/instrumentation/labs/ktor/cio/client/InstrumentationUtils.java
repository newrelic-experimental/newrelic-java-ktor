package com.newrelic.instrumentation.labs.ktor.cio.client;

import io.ktor.client.request.HttpRequestData;
import io.ktor.http.Headers;

public class InstrumentationUtils {

    public static HttpRequestData getUpdatedHttpRequestData(HttpRequestData data, Headers headers) {
        return UtilsKt.getUpatedHttpRequestData(data);
    }

}
