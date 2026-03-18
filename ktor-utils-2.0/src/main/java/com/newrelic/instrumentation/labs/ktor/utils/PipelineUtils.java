package com.newrelic.instrumentation.labs.ktor.utils;

import com.newrelic.agent.kotlincoroutines.KotlinCoroutinesService;
import com.newrelic.agent.service.ServiceFactory;

import java.util.HashSet;
import java.util.Set;

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

    private static final Set<String> PIPELINES_TO_TRACK = new HashSet<String>();

    static {
        PIPELINES_TO_TRACK.add("HttpResponsePipeline");
    }


    public static boolean tracePipeline(String pipelineName) {
        return PIPELINES_TO_TRACK.contains(pipelineName);
    }

}
