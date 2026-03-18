package com.newrelic.instrumentation.labs.ktor.server;

import com.newrelic.agent.kotlincoroutines.KotlinCoroutinesService;
import com.newrelic.agent.service.ServiceFactory;

public class KtorServerUtils {

    public static boolean initialized = false;

    public static void init() {
        if(initialized) {
            return;
        }
        KotlinCoroutinesService coroutinesService = ServiceFactory.getKotlinCoroutinesService();
        String pattern = "io\\.ktor\\.server\\..*";
        coroutinesService.addIgnoredRegExContinuation(pattern);
        coroutinesService.addIgnoredRegexSuspends(pattern);
        coroutinesService.addIgnoredRegexDispatched(pattern);
        initialized = true;
    }

}
