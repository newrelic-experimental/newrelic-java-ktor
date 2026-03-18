package com.newrelic.instrumentation.labs.ktor.utils;

import com.newrelic.agent.kotlincoroutines.KotlinCoroutinesService;
import com.newrelic.agent.service.ServiceFactory;

public class PipelineUtils {

    public static boolean initialized = false;

    public static void init() {
        if (initialized) {
            return;
        }
        String pattern = "io\\.ktor\\.util\\..*";
        KotlinCoroutinesService coroutinesService = ServiceFactory.getKotlinCoroutinesService();
        coroutinesService.addIgnoredRegexSuspends(pattern);
        coroutinesService.addIgnoredRegexDispatched(pattern);
        coroutinesService.addIgnoredRegExContinuation(pattern);
        initialized = true;
    }
}
