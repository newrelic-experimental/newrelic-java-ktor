package com.newrelic.labs.instrumentation.ktor.jetty.jakarta;

import com.newrelic.agent.kotlincoroutines.KotlinCoroutinesService;
import com.newrelic.agent.service.ServiceFactory;
import io.ktor.server.application.Application;

public class Utils {

    public static boolean initialized = false;

    public static void init() {
        if(initialized) {
            return;
        }
        KotlinCoroutinesService coroutinesService = ServiceFactory.getKotlinCoroutinesService();
        String pattern = "io\\.ktor\\.server\\.jetty\\.jakarta\\..*";
        coroutinesService.addIgnoredRegExContinuation(pattern);
        coroutinesService.addIgnoredRegexSuspends(pattern);
        coroutinesService.addIgnoredRegexDispatched(pattern);
        initialized = true;
    }

    public static String getApplicationName(Application app) {
        if (app != null) {
            return app.getClass().getSimpleName();
        }
        return "Unknown";
    }
    
    public static String getTransactionName(String uri, String method) {
        StringBuilder sb = new StringBuilder();
        
        if (uri != null) {
            if (uri.startsWith("/")) {
                uri = uri.substring(1);
            }
            if (uri.isEmpty()) {
                sb.append("Root");
            } else {
                sb.append(uri);
            }
        } else {
            sb.append("Unknown");
        }
        
        if (method != null && !method.isEmpty()) {
            sb.append(" - {");
            sb.append(method);
            sb.append("}");
        }
        
        return sb.toString();
    }
}