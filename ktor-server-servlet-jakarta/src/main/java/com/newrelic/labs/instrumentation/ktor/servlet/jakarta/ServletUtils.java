package com.newrelic.labs.instrumentation.ktor.servlet.jakarta;

import com.newrelic.agent.kotlincoroutines.KotlinCoroutinesService;
import com.newrelic.agent.service.ServiceFactory;

public class ServletUtils {

    public static boolean initialized = false;

    public static void init() {
        if(initialized) {
            return;
        }
        KotlinCoroutinesService coroutinesService = ServiceFactory.getKotlinCoroutinesService();
        String pattern = "io\\.ktor\\.server\\.servlet\\jakarta\\..*";
        coroutinesService.addIgnoredRegExContinuation(pattern);
        coroutinesService.addIgnoredRegexSuspends(pattern);
        coroutinesService.addIgnoredRegexDispatched(pattern);
        initialized = true;
    }
}
