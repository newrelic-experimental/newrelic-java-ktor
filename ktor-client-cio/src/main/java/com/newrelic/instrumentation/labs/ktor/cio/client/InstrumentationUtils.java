package com.newrelic.instrumentation.labs.ktor.cio.client;

import com.newrelic.agent.kotlincoroutines.KotlinCoroutinesService;
import com.newrelic.agent.service.ServiceFactory;
import io.ktor.client.request.HttpRequestData;
import io.ktor.http.Headers;

public class InstrumentationUtils {

    public static boolean initialized = false;

    public static void init() {
        String regEx = "io\\.ktor\\.client\\.engine\\.cio.*";
        if (!initialized) {
            KotlinCoroutinesService kotlinCoroutinesService = ServiceFactory.getKotlinCoroutinesService();
            kotlinCoroutinesService.addIgnoredRegexSuspends(regEx);
            kotlinCoroutinesService.addIgnoredRegExContinuation(regEx);
            kotlinCoroutinesService.addIgnoredRegexDispatched(regEx);
            initialized = true;
        }
    }

    public static HttpRequestData getUpdatedHttpRequestData(HttpRequestData data, Headers headers) {
        return UtilsKt.getUpatedHttpRequestData(data);
    }


}
