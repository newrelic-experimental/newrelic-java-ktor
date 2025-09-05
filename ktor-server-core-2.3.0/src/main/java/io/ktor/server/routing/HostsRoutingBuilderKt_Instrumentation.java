package io.ktor.server.routing;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TracedMethod;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.ktor.server.NRFunction1RoutingHostWrapper;
import kotlin.jvm.functions.Function1;
import kotlin.Unit;
import kotlin.text.Regex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Weave(originalName = "io.ktor.server.routing.HostsRoutingBuilderKt")
public class HostsRoutingBuilderKt_Instrumentation {

    public static Route host(Route route, String host, int port, Function1<? super Route,Unit> function1) {
        if(function1 != null && !(function1 instanceof NRFunction1RoutingHostWrapper)) {
            function1 = new NRFunction1RoutingHostWrapper<>(function1, host, port, "host");
        }
        return Weaver.callOriginal();
    }

    @Trace
    public static Route host(Route route, Regex hostRegex, int port, Function1<? super Route,Unit> function1) {
        if(function1 != null && !(function1 instanceof NRFunction1RoutingHostWrapper)) {
            function1 = new NRFunction1RoutingHostWrapper<>(function1, hostRegex.toString(), port, "hostRegex");
        }
        return Weaver.callOriginal();
    }

    @Trace
    public static Route host(Route route, List<String> hosts, List<Integer> ports, Function1<? super Route,Unit> function1) {
        if(function1 != null && !(function1 instanceof NRFunction1RoutingHostWrapper)) {
            function1 = new NRFunction1RoutingHostWrapper<>(function1, hosts , ports, "hostFromList");
        }
        return Weaver.callOriginal();
    }

    @Trace
    public static Route host(Route route, List<String> hosts, List<Regex> hostPatterns, List<Integer> ports, Function1<? super Route,Unit> function1) {
        if(function1 != null && !(function1 instanceof NRFunction1RoutingHostWrapper)) {
            function1 = new NRFunction1RoutingHostWrapper<>(function1, hosts , ports, "hostFromList");
        }
        return Weaver.callOriginal();
    }

    @Trace
    public static Route port(Route route, int[] ports, Function1<? super Route,Unit> function1) {
        List<Integer> portList = new ArrayList<>(ports.length);
        if(function1 != null && !(function1 instanceof NRFunction1RoutingHostWrapper)) {
            for (int port : ports) {
                portList.add(port);
            }
            function1 = new NRFunction1RoutingHostWrapper<>(function1, (List<String>) null, portList, "PortsFromArray");
        }
        return Weaver.callOriginal();
    }
}
