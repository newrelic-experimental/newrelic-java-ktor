package com.newrelic.instrumentation.labs.ktor.client;

import com.newrelic.api.agent.HttpParameters;
import kotlin.coroutines.Continuation;

public class KtorClientUtils {

    public static <T> NRContinuationWrapper<T> getContinuationWrapper(Continuation<T> continuation, HttpParameters httpParameters) {
        if(continuation instanceof NRContinuationWrapper) {
            return null;
        }
        return new NRContinuationWrapper<>(continuation, httpParameters);
    }
}
