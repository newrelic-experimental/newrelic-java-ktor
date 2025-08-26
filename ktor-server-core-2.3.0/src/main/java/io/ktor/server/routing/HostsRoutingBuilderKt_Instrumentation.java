package io.ktor.server.routing;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TracedMethod;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import kotlin.jvm.functions.Function1;
import kotlin.Unit;
import kotlin.text.Regex;

import java.util.Arrays;
import java.util.List;

@Weave(originalName = "io.ktor.server.routing.HostsRoutingBuilderKt")
public class HostsRoutingBuilderKt_Instrumentation {

    @Trace
    public static Route host(Route route, String host, int port, Function1<? super Route,Unit> function1) {
        TracedMethod traced = NewRelic.getAgent().getTracedMethod();
        traced.addCustomAttribute("Host", host);
        traced.addCustomAttribute("Port", port);
        return Weaver.callOriginal();
    }

    @Trace
    public static Route host(Route route, Regex hostRegex, int port, Function1<? super Route,Unit> function1) {
        TracedMethod traced = NewRelic.getAgent().getTracedMethod();
        traced.addCustomAttribute("HostRegex", hostRegex.toString());
        traced.addCustomAttribute("Port", port);
        return Weaver.callOriginal();
    }

    @Trace
    public static Route host(Route route, List<String> hosts, List<Integer> ports, Function1<? super Route,Unit> function1) {
        TracedMethod traced = NewRelic.getAgent().getTracedMethod();
        traced.addCustomAttribute("Hosts", hosts.toString());
        traced.addCustomAttribute("Ports", ports.toString());
        return Weaver.callOriginal();
    }

    @Trace
    public static Route host(Route route, List<String> hosts, List<Regex> hostPatterns, List<Integer> ports, Function1<? super Route,Unit> function1) {
        TracedMethod traced = NewRelic.getAgent().getTracedMethod();
        traced.addCustomAttribute("Hosts", hosts.toString());
        traced.addCustomAttribute("HostsRegex", hostPatterns.toString());
        traced.addCustomAttribute("Ports", ports.toString());
        return Weaver.callOriginal();
    }

    @Trace
    public static Route port(Route route, int[] ports, Function1<? super Route,Unit> function1) {
        TracedMethod traced = NewRelic.getAgent().getTracedMethod();
        traced.addCustomAttribute("Ports", Arrays.toString(ports));
        return Weaver.callOriginal();
    }

}
