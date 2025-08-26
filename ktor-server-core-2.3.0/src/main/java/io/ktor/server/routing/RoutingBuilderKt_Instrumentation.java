package io.ktor.server.routing;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.ktor.server.NRFunction3Wrapper;
import io.ktor.server.application.ApplicationCall;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import io.ktor.http.HttpMethod;
import io.ktor.http.ContentType;
import kotlin.jvm.functions.Function3;
import io.ktor.util.pipeline.PipelineContext;

@Weave(originalName = "io.ktor.server.routing.RoutingBuilderKt")
public class RoutingBuilderKt_Instrumentation {

    @Trace
    public static Route route(Route route, String path, Function1<? super Route, Unit> function1) {
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("Path", path);
        return Weaver.callOriginal();
    }

    @Trace
    public static Route route(Route route, String path, HttpMethod method, Function1<? super Route, Unit> function1) {
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("Path", path);
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("Method", method.toString());
        return Weaver.callOriginal();
    }

    @Trace
    public static Route method(Route route, HttpMethod method, Function1<? super Route, Unit> function1) {
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("Method", method.toString());
        return Weaver.callOriginal();
    }

    @Trace
    public static Route param(Route route, String name, String value, Function1<? super Route, Unit> function1) {
        return Weaver.callOriginal();
    }

    @Trace
    public static Route param(Route route, String name, Function1<? super Route, Unit> function1) {
        return Weaver.callOriginal();
    }

    @Trace
    public static Route optionalParam(Route route, String name, Function1<? super Route, Unit> function1) {
        return Weaver.callOriginal();
    }

    @Trace
    public static Route header(Route route, String name, String value, Function1<? super Route, Unit> function1) {
        return Weaver.callOriginal();
    }

    @Trace
    public static Route accept(Route route,ContentType[] contentType, Function1<? super Route, Unit> function1) {
        return Weaver.callOriginal();
    }

    @Trace
    public static Route contentType(Route route,ContentType contentType, Function1<? super Route, Unit> function1) {
        return Weaver.callOriginal();
    }

    @Trace
    public static Route get(Route route, String path, Function3<? super PipelineContext<Unit, ApplicationCall>, ? super Unit, ? super Continuation<? super Unit>, Object> function3) {
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("Path", path);
        if (function3 != null && !(function3 instanceof NRFunction3Wrapper))  {
            function3 = new NRFunction3Wrapper<>(function3,route);
        }
        return Weaver.callOriginal();
    }

    @Trace
    public static Route get(Route route, Function3<? super PipelineContext<Unit, ApplicationCall>, ? super Unit, ? super Continuation<? super Unit>, Object> function3) {
        if (function3 != null && !(function3 instanceof NRFunction3Wrapper))  {
            function3 = new NRFunction3Wrapper<>(function3,route);
        }
        return Weaver.callOriginal();
    }

    @Trace
    public static Route post(Route route, String path, Function3<? super PipelineContext<Unit, ApplicationCall>, ? super Unit, ? super Continuation<? super Unit>, Object> function3) {
        if (function3 != null && !(function3 instanceof NRFunction3Wrapper))  {
            function3 = new NRFunction3Wrapper<>(function3,route);
        }
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("Path", path);
        return Weaver.callOriginal();
    }

    @Trace
    public static Route post(Route route, Function3<? super PipelineContext<Unit, ApplicationCall>, ? super Unit, ? super Continuation<? super Unit>, Object> function3) {
        if (function3 != null && !(function3 instanceof NRFunction3Wrapper))  {
            function3 = new NRFunction3Wrapper<>(function3,route);
        }
        return Weaver.callOriginal();
    }

    @Trace
    public static Route head(Route route, String path, Function3<? super PipelineContext<Unit, ApplicationCall>, ? super Unit, ? super Continuation<? super Unit>, Object> function3) {
        if (function3 != null && !(function3 instanceof NRFunction3Wrapper))  {
            function3 = new NRFunction3Wrapper<>(function3,route);
        }
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("Path", path);
        return Weaver.callOriginal();
    }

    @Trace
    public static Route head(Route route, Function3<? super PipelineContext<Unit, ApplicationCall>, ? super Unit, ? super Continuation<? super Unit>, Object> function3) {
        if (function3 != null && !(function3 instanceof NRFunction3Wrapper))  {
            function3 = new NRFunction3Wrapper<>(function3,route);
        }
        return Weaver.callOriginal();
    }

    @Trace
    public static Route put(Route route, String path, Function3<? super PipelineContext<Unit, ApplicationCall>, ? super Unit, ? super Continuation<? super Unit>, Object> function3) {
        if (function3 != null && !(function3 instanceof NRFunction3Wrapper))  {
            function3 = new NRFunction3Wrapper<>(function3,route);
        }
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("Path", path);
        return Weaver.callOriginal();
    }

    @Trace
    public static Route put(Route route, Function3<? super PipelineContext<Unit, ApplicationCall>, ? super Unit, ? super Continuation<? super Unit>, Object> function3) {
        if (function3 != null && !(function3 instanceof NRFunction3Wrapper))  {
            function3 = new NRFunction3Wrapper<>(function3,route);
        }
        return Weaver.callOriginal();
    }

    @Trace
    public static Route patch(Route route, String path, Function3<? super PipelineContext<Unit, ApplicationCall>, ? super Unit, ? super Continuation<? super Unit>, Object> function3) {
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("Path", path);
        if (function3 != null && !(function3 instanceof NRFunction3Wrapper))  {
            function3 = new NRFunction3Wrapper<>(function3,route);
        }
        return Weaver.callOriginal();
    }

    @Trace
    public static Route patch(Route route, Function3<? super PipelineContext<Unit, ApplicationCall>, ? super Unit, ? super Continuation<? super Unit>, Object> function3) {
        if (function3 != null && !(function3 instanceof NRFunction3Wrapper))  {
            function3 = new NRFunction3Wrapper<>(function3,route);
        }
        return Weaver.callOriginal();
    }

    @Trace
    public static Route delete(Route route, String path, Function3<? super PipelineContext<Unit, ApplicationCall>, ? super Unit, ? super Continuation<? super Unit>, Object> function3) {
        if (function3 != null && !(function3 instanceof NRFunction3Wrapper))  {
            function3 = new NRFunction3Wrapper<>(function3,route);
        }
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("Path", path);
        return Weaver.callOriginal();
    }

    @Trace
    public static Route delete(Route route, Function3<? super PipelineContext<Unit, ApplicationCall>, ? super Unit, ? super Continuation<? super Unit>, Object> function3) {
        if (function3 != null && !(function3 instanceof NRFunction3Wrapper))  {
            function3 = new NRFunction3Wrapper<>(function3,route);
        }
        return Weaver.callOriginal();
    }

    @Trace
    public static Route options(Route route, String path, Function3<? super PipelineContext<Unit, ApplicationCall>, ? super Unit, ? super Continuation<? super Unit>, Object> function3) {
        if (function3 != null && !(function3 instanceof NRFunction3Wrapper))  {
            function3 = new NRFunction3Wrapper<>(function3,route);
        }
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("Path", path);
        return Weaver.callOriginal();
    }

    @Trace
    public static Route options(Route route, Function3<? super PipelineContext<Unit, ApplicationCall>, ? super Unit, ? super Continuation<? super Unit>, Object> function3) {
        if (function3 != null && !(function3 instanceof NRFunction3Wrapper))  {
            function3 = new NRFunction3Wrapper<>(function3,route);
        }
        return Weaver.callOriginal();
    }
}
