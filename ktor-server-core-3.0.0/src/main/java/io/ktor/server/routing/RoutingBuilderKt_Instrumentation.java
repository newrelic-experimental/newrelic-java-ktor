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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import io.ktor.util.pipeline.PipelineContext;

@Weave(originalName = "io.ktor.server.routing.RoutingBuilderKt")
public class RoutingBuilderKt_Instrumentation {

    public static Route route(Route route, String path, Function1<? super Route, kotlin.Unit> function1) {
        return Weaver.callOriginal();
    }

    public static Route route(Route route, String path, HttpMethod method, Function1<? super Route, kotlin.Unit> function1) {
        return Weaver.callOriginal();
    }
    
    public static Route method(Route route, HttpMethod method, Function1<? super Route, kotlin.Unit> function1) {
        return Weaver.callOriginal();
    }
    
    public static Route param(Route route, String name, String value, Function1<? super Route, kotlin.Unit> function1) {
        return Weaver.callOriginal();
    }
    
    public static Route param(Route route, String name, Function1<? super Route, kotlin.Unit> function1) {
        return Weaver.callOriginal();
    }
    
    public static Route optionalParam(Route route, String name, Function1<? super Route, kotlin.Unit> function1) {
        return Weaver.callOriginal();
    }
    
    public static Route header(Route route, String name, String value, Function1<? super Route, kotlin.Unit> function1) {
        return Weaver.callOriginal();
    }
    
    public static Route accept(Route route, ContentType[] contentTypes, Function1<? super Route, kotlin.Unit> function1) {
        return Weaver.callOriginal();
    }
    
    public static Route contentType(Route route, ContentType contentType, Function1<? super Route, kotlin.Unit> function1) {
        return Weaver.callOriginal();
    }
    
    public static Route get(Route route, String path, Function2<? super RoutingContext, ? super Continuation<? super kotlin.Unit>, Object> function2) {
        return Weaver.callOriginal();
    }
    
    public static Route get(Route route, Function2<? super RoutingContext, ? super Continuation<? super kotlin.Unit>, Object> function2) {
        return Weaver.callOriginal();
    }
    
    public static Route post(Route route, String path, Function2<? super RoutingContext, ? super Continuation<? super kotlin.Unit>, Object> function2) {
        return Weaver.callOriginal();
    }
    
    public static Route post(Route route, Function2<? super RoutingContext, ? super Continuation<? super kotlin.Unit>, Object> function2) {
        return Weaver.callOriginal();
    }

    public static Route head(Route route, String path, Function2<? super RoutingContext, ? super Continuation<? super kotlin.Unit>, Object> function2) {
        return Weaver.callOriginal();
    }

    public static Route head(Route route, Function2<? super RoutingContext, ? super Continuation<? super kotlin.Unit>, Object> function2) {
        return Weaver.callOriginal();
    }

    public static Route put(Route route, String path, Function2<? super RoutingContext, ? super Continuation<? super kotlin.Unit>, Object> function2) {
        return Weaver.callOriginal();
    }

    public static Route put(Route route, Function2<? super RoutingContext, ? super Continuation<? super kotlin.Unit>, Object> function2) {
        return Weaver.callOriginal();
    }

    public static Route patch(Route route, String path, Function2<? super RoutingContext, ? super Continuation<? super kotlin.Unit>, Object> function2) {
        return Weaver.callOriginal();
    }

    public static Route patch(Route route, Function2<? super RoutingContext, ? super Continuation<? super kotlin.Unit>, Object> function2) {
        return Weaver.callOriginal();
    }

    public static Route delete(Route route, String path, Function2<? super RoutingContext, ? super Continuation<? super kotlin.Unit>, Object> function2) {
        return Weaver.callOriginal();
    }

    public static Route delete(Route route, Function2<? super RoutingContext, ? super Continuation<? super kotlin.Unit>, Object> function2) {
        return Weaver.callOriginal();
    }

    public static Route options(Route route, String path, Function2<? super RoutingContext, ? super Continuation<? super kotlin.Unit>, Object> function2) {
        return Weaver.callOriginal();
    }

    public static Route options(Route route, Function2<? super RoutingContext, ? super Continuation<? super kotlin.Unit>, Object> function2) {
        return Weaver.callOriginal();
    }

}
