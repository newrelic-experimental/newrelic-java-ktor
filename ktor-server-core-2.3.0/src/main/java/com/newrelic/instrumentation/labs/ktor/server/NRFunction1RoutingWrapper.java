package com.newrelic.instrumentation.labs.ktor.server;

import com.newrelic.agent.bridge.AgentBridge;
import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TracedMethod;
import com.newrelic.api.agent.Transaction;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.Nullable;

public class NRFunction1RoutingWrapper<A,B> implements Function1<A,B> {

    private final Function1<A,B> wrapped;
    @Nullable
    private String path =  null;
    @Nullable
    private String operation = null;

    private static boolean isTransformed = false;

    public NRFunction1RoutingWrapper(Function1<A,B> wrapped, @Nullable String path, @Nullable String op) {
        this.wrapped = wrapped;
        this.path = path;
        this.operation = op;
        if(!isTransformed) {
            AgentBridge.instrumentation.retransformUninstrumentedClass(getClass());
            isTransformed = true;
        }
    }

    @Override
    @Trace(dispatcher = true)
    public B invoke(A a) {
        Transaction transaction = NewRelic.getAgent().getTransaction();
        if(!transaction.isWebTransaction()) {
            transaction.convertToWebTransaction();
        }
        TracedMethod traced = NewRelic.getAgent().getTracedMethod();
        if(operation != null) {
            String routeString = path != null ? path + " (" + operation + ")" : "(" + operation + ")";
            traced.addCustomAttribute("route", routeString);
            traced.setMetricName("Custom","Ktor","Routing","Wrapper",operation);
        }
        return wrapped.invoke(a);
    }
}
