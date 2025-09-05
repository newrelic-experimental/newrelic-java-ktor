package io.ktor.server.routing;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.ktor.server.NRFunction1RoutingWrapper;
import com.newrelic.instrumentation.labs.ktor.server.NRFunction3RoutingWrapper;
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

    public static Route route(Route route, String path, Function1<? super Route, Unit> function1) {
        if(function1 != null && !(function1 instanceof NRFunction1RoutingWrapper)) {
            function1 = new NRFunction1RoutingWrapper<>(function1, path, "ROUTE");
        }
        return Weaver.callOriginal();
    }

    public static Route route(Route route, String path, HttpMethod method, Function1<? super Route, Unit> function1) {
        if(function1 != null && !(function1 instanceof NRFunction1RoutingWrapper)) {
            function1 = new NRFunction1RoutingWrapper<>(function1, path, method.toString());
        }
        return Weaver.callOriginal();
    }

    public static Route method(Route route, HttpMethod method, Function1<? super Route, Unit> function1) {
        if(function1 != null && !(function1 instanceof NRFunction1RoutingWrapper)) {
            function1 = new NRFunction1RoutingWrapper<>(function1, null, method.toString());
        }
        return Weaver.callOriginal();
    }

    public static Route param(Route route, String name, String value, Function1<? super Route, Unit> function1) {
        if(function1 != null && !(function1 instanceof NRFunction1RoutingWrapper)) {
            function1 = new NRFunction1RoutingWrapper<>(function1, null, "PARAM");
        }
        return Weaver.callOriginal();
    }

    public static Route param(Route route, String name, Function1<? super Route, Unit> function1) {
        if(function1 != null && !(function1 instanceof NRFunction1RoutingWrapper)) {
            function1 = new NRFunction1RoutingWrapper<>(function1, null, "PARAM");
        }
        return Weaver.callOriginal();
    }

    public static Route optionalParam(Route route, String name, Function1<? super Route, Unit> function1) {
        if(function1 != null && !(function1 instanceof NRFunction1RoutingWrapper)) {
            function1 = new NRFunction1RoutingWrapper<>(function1, null, "OPTIONAL_PARAM");
        }
        return Weaver.callOriginal();
    }

    public static Route header(Route route, String name, String value, Function1<? super Route, Unit> function1) {
        if(function1 != null && !(function1 instanceof NRFunction1RoutingWrapper)) {
            function1 = new NRFunction1RoutingWrapper<>(function1, null, "HEADER");
        }
        return Weaver.callOriginal();
    }

    public static Route contentType(Route route,ContentType contentType, Function1<? super Route, Unit> function1) {
        return Weaver.callOriginal();
    }

    public static Route get(Route route, String path, Function3<? super PipelineContext<Unit, ApplicationCall>, ? super Unit, ? super Continuation<? super Unit>, Object> function3) {
        if (function3 != null && !(function3 instanceof NRFunction3RoutingWrapper))  {
            NRFunction3RoutingWrapper<? super PipelineContext<Unit, ApplicationCall>, ? super Unit, ? super Continuation<? super Unit>, Object> wrapper = new NRFunction3RoutingWrapper<>(function3,path, "GET");
        }
        return Weaver.callOriginal();
    }

    public static Route get(Route route, Function3<? super PipelineContext<Unit, ApplicationCall>, ? super Unit, ? super Continuation<? super Unit>, Object> function3) {
        if (function3 != null && !(function3 instanceof NRFunction3RoutingWrapper))  {
            function3 = new NRFunction3RoutingWrapper<>(function3,null, "GET");
        }
        return Weaver.callOriginal();
    }

    public static Route post(Route route, String path, Function3<? super PipelineContext<Unit, ApplicationCall>, ? super Unit, ? super Continuation<? super Unit>, Object> function3) {
        if (function3 != null && !(function3 instanceof NRFunction3RoutingWrapper))  {
            function3 = new NRFunction3RoutingWrapper<>(function3, path, "POST");
        }
        return Weaver.callOriginal();
    }

    public static Route post(Route route, Function3<? super PipelineContext<Unit, ApplicationCall>, ? super Unit, ? super Continuation<? super Unit>, Object> function3) {
        if (function3 != null && !(function3 instanceof NRFunction3RoutingWrapper))  {
            function3 = new NRFunction3RoutingWrapper<>(function3,null, "POST");
        }
        return Weaver.callOriginal();
    }

    public static Route head(Route route, String path, Function3<? super PipelineContext<Unit, ApplicationCall>, ? super Unit, ? super Continuation<? super Unit>, Object> function3) {
        if (function3 != null && !(function3 instanceof NRFunction3RoutingWrapper))  {
            function3 = new NRFunction3RoutingWrapper<>(function3, path, "HEAD");
        }
        return Weaver.callOriginal();
    }

    public static Route head(Route route, Function3<? super PipelineContext<Unit, ApplicationCall>, ? super Unit, ? super Continuation<? super Unit>, Object> function3) {
        if (function3 != null && !(function3 instanceof NRFunction3RoutingWrapper))  {
            function3 = new NRFunction3RoutingWrapper<>(function3,null, "HEAD");
        }
        return Weaver.callOriginal();
    }

    public static Route put(Route route, String path, Function3<? super PipelineContext<Unit, ApplicationCall>, ? super Unit, ? super Continuation<? super Unit>, Object> function3) {
        if (function3 != null && !(function3 instanceof NRFunction3RoutingWrapper))  {
            function3 = new NRFunction3RoutingWrapper<>(function3, path, "PUT");
        }
        return Weaver.callOriginal();
    }

    public static Route put(Route route, Function3<? super PipelineContext<Unit, ApplicationCall>, ? super Unit, ? super Continuation<? super Unit>, Object> function3) {
        if (function3 != null && !(function3 instanceof NRFunction3RoutingWrapper))  {
            function3 = new NRFunction3RoutingWrapper<>(function3,null, "PUT");
        }
        return Weaver.callOriginal();
    }

    public static Route patch(Route route, String path, Function3<? super PipelineContext<Unit, ApplicationCall>, ? super Unit, ? super Continuation<? super Unit>, Object> function3) {
        if (function3 != null && !(function3 instanceof NRFunction3RoutingWrapper))  {
            function3 = new NRFunction3RoutingWrapper<>(function3, path, "PATCH");
        }
        return Weaver.callOriginal();
    }

    public static Route patch(Route route, Function3<? super PipelineContext<Unit, ApplicationCall>, ? super Unit, ? super Continuation<? super Unit>, Object> function3) {
        if (function3 != null && !(function3 instanceof NRFunction3RoutingWrapper))  {
            function3 = new NRFunction3RoutingWrapper<>(function3,null, "PATCH");
        }
        return Weaver.callOriginal();
    }

    public static Route delete(Route route, String path, Function3<? super PipelineContext<Unit, ApplicationCall>, ? super Unit, ? super Continuation<? super Unit>, Object> function3) {
        if (function3 != null && !(function3 instanceof NRFunction3RoutingWrapper))  {
            function3 = new NRFunction3RoutingWrapper<>(function3, path, "DELETE");
        }
        return Weaver.callOriginal();
    }

    public static Route delete(Route route, Function3<? super PipelineContext<Unit, ApplicationCall>, ? super Unit, ? super Continuation<? super Unit>, Object> function3) {
        if (function3 != null && !(function3 instanceof NRFunction3RoutingWrapper))  {
            function3 = new NRFunction3RoutingWrapper<>(function3,null, "DELETE");
        }
        return Weaver.callOriginal();
    }

    public static Route options(Route route, String path, Function3<? super PipelineContext<Unit, ApplicationCall>, ? super Unit, ? super Continuation<? super Unit>, Object> function3) {
        if (function3 != null && !(function3 instanceof NRFunction3RoutingWrapper))  {
            function3 = new NRFunction3RoutingWrapper<>(function3, path, "OPTIONS");
        }
        return Weaver.callOriginal();
    }

    public static Route options(Route route, Function3<? super PipelineContext<Unit, ApplicationCall>, ? super Unit, ? super Continuation<? super Unit>, Object> function3) {
        if (function3 != null && !(function3 instanceof NRFunction3RoutingWrapper))  {
            function3 = new NRFunction3RoutingWrapper<>(function3,null, "OPTIONS");
        }
        return Weaver.callOriginal();
    }
}
