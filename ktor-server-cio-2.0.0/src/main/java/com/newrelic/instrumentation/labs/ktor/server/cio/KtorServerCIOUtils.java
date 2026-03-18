package com.newrelic.instrumentation.labs.ktor.server.cio;

import com.newrelic.agent.kotlincoroutines.KotlinCoroutinesService;
import com.newrelic.agent.service.ServiceFactory;

public class KtorServerCIOUtils {

    public static boolean initialized = false;

    public static void init() {
        if(initialized) {
            return;
        }
        KotlinCoroutinesService coroutinesService = ServiceFactory.getKotlinCoroutinesService();
        String pattern = "io\\.ktor\\.server\\.cio\\..*";
        coroutinesService.addIgnoredRegExContinuation(pattern);
        coroutinesService.addIgnoredRegexSuspends(pattern);
        coroutinesService.addIgnoredRegexDispatched(pattern);
        initialized = true;
    }

}
