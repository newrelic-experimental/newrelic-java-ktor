package io.ktor.http;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import io.ktor.application.ApplicationCall;
import kotlin.jvm.functions.Function1;
import io.ktor.response.ResponsePushBuilder;
import kotlin.Unit;

@Weave(originalName = "io.ktor.http.PushKt")
public class PushKt_Instrumentation {

    @Trace
    public static void push(ApplicationCall call, String pathAndQuery) {
        Weaver.callOriginal();
    }

    public static void push(ApplicationCall call, String pathAndQuery, Parameters params) {
        Weaver.callOriginal();
    }

    public static void push(ApplicationCall call, Function1<? super ResponsePushBuilder, Unit> function1) {
        Weaver.callOriginal();
    }
}
