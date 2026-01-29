package com.newrelic.instrumentation.labs.ktor.client;

import com.newrelic.agent.bridge.AgentBridge;
import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Token;
import com.newrelic.api.agent.Trace;
import kotlin.jvm.functions.Function3;

public class NRFunction3Wrapper<A,B,C,D> implements Function3<A,B,C,D> {

    private final Function3<A,B,C,D> delegate;
    private static boolean isTransformed = false;

    public NRFunction3Wrapper(Function3<A,B,C,D> delegate) {
        this.delegate = delegate;
        if(!isTransformed) {
            AgentBridge.instrumentation.retransformUninstrumentedClass(getClass());
            isTransformed = true;
        }
    }

    @Override
    @Trace(dispatcher = true)
    public D invoke(A a, B b, C c) {
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("Delegate", delegate.getClass().getName());
        return delegate.invoke(a, b, c);
    }
}
