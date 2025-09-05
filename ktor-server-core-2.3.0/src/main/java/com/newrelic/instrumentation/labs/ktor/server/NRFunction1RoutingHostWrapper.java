package com.newrelic.instrumentation.labs.ktor.server;

import com.newrelic.agent.bridge.AgentBridge;
import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TracedMethod;
import com.newrelic.api.agent.Transaction;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class NRFunction1RoutingHostWrapper<A,B> implements Function1<A,B> {

    private final Function1<A,B> wrapped;
    @Nullable
    private String host =  null;
    @Nullable
    private String operation = null;
    @Nullable
    private Integer port =  null;
    @Nullable
    private List<String> hosts =  null;
    @Nullable
    private List<Integer> ports =  null;

    private static boolean isTransformed = false;

    public NRFunction1RoutingHostWrapper(Function1<A,B> wrapped, @Nullable String path, Integer port, @Nullable String op) {
        this.wrapped = wrapped;
        this.host = path;
        this.operation = op;
        this.port = port;
        if(!isTransformed) {
            AgentBridge.instrumentation.retransformUninstrumentedClass(getClass());
            isTransformed = true;
        }
    }

    public NRFunction1RoutingHostWrapper(Function1<A,B> wrapped, @Nullable List<String> hosts, @Nullable List<Integer> ports, @Nullable String op) {
        this.wrapped = wrapped;
        this.hosts = hosts;
        this.ports = ports;
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
            if(host != null) {
                traced.addCustomAttribute("host", host);
            }
            if(hosts != null) {
                traced.addCustomAttribute("hosts",hosts.toString());
            }
            if(port != null) {
                traced.addCustomAttribute("port", port);
            }
            if(ports != null) {
                traced.addCustomAttribute("ports",ports.toString());
            }
            if(operation != null) {
                traced.addCustomAttribute("operation", operation);
            }
            traced.setMetricName("Custom","Ktor","HostRouting","Wrapper",operation);
        }
        return wrapped.invoke(a);
    }
}
