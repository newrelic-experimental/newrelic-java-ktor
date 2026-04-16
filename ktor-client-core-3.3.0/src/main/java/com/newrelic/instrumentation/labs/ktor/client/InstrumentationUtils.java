package com.newrelic.instrumentation.labs.ktor.client;

import kotlin.jvm.functions.Function3;

public class InstrumentationUtils {

    public static <A,B,C,D> NRFunction3Wrapper<A,B,C,D> getWrapper(Function3<A,B,C,D> delegate, String phase, String pipelineName) {
        if(delegate == null) return null;

        if(delegate instanceof NRFunction3Wrapper) return null;

        return new NRFunction3Wrapper<>(delegate,phase,pipelineName);
    }
}
