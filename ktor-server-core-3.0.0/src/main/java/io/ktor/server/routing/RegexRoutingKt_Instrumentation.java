package io.ktor.server.routing;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import io.ktor.http.HttpMethod;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.text.Regex;

@Weave(originalName = "io.ktor.server.routing.RegexRoutingKt")
public class RegexRoutingKt_Instrumentation {

    @Trace
    public static Route route(Route route, Regex regex, Function1<? super Route, Unit> function1) {
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("Regex", regex.toString());
        return Weaver.callOriginal();
    }

    @Trace
    public static Route route(Route route, Regex regex, HttpMethod method, Function1<? super Route, Unit> function1) {
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("Regex", regex.toString());
        return Weaver.callOriginal();
    }

    @Trace
    public static Route get(Route route, Regex regex, Function2<? super RoutingContext, ? super Continuation<? super Unit>, Object> function2) {
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("Regex", regex.toString());
        return Weaver.callOriginal();
    }

    @Trace
    public static Route post(Route route, Regex regex, Function2<? super RoutingContext, ? super Continuation<? super Unit>, Object> function2) {
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("Regex", regex.toString());
        return Weaver.callOriginal();
    }

    @Trace
    public static Route head(Route route, Regex regex, Function2<? super RoutingContext, ? super Continuation<? super Unit>, Object> function2) {
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("Regex", regex.toString());
        return Weaver.callOriginal();
    }

    @Trace
    public static Route put(Route route, Regex regex, Function2<? super RoutingContext, ? super Continuation<? super Unit>, Object> function2) {
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("Regex", regex.toString());
        return Weaver.callOriginal();
    }

    @Trace
    public static Route patch(Route route, Regex regex, Function2<? super RoutingContext, ? super Continuation<? super Unit>, Object> function2) {
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("Regex", regex.toString());
        return Weaver.callOriginal();
    }

    @Trace
    public static Route delete(Route route, Regex regex, Function2<? super RoutingContext, ? super Continuation<? super Unit>, Object> function2) {
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("Regex", regex.toString());
        return Weaver.callOriginal();
    }

    @Trace
    public static Route options(Route route, Regex regex, Function2<? super RoutingContext, ? super Continuation<? super Unit>, Object> function2) {
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("Regex", regex.toString());
        return Weaver.callOriginal();
    }

}
