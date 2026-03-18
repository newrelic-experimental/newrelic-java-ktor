package io.ktor.response;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.ktor.server.KtorExtendedResponse;
import io.ktor.application.ApplicationCall;
import kotlin.coroutines.Continuation;
import kotlin.Unit;
import io.ktor.http.HttpStatusCode;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import io.ktor.http.URLBuilder;
import io.ktor.http.ContentType;
import java.io.File;
import java.io.OutputStream;
import java.io.Writer;

import io.ktor.http.content.OutgoingContent;

@Weave(originalName = "io.ktor.response.ApplicationResponseFunctionsKt")
public class ApplicationResponseFunctionsKt_Instrumentation {

    @Trace
    public static Object respond(ApplicationCall call, Object message, Continuation<? super Unit> continuation) {
        KtorExtendedResponse extendedResponse = new KtorExtendedResponse(call);
        NewRelic.getAgent().getTransaction().setWebResponse(extendedResponse);
        return Weaver.callOriginal();
    }

    @Trace
    public static Object respond(ApplicationCall call, HttpStatusCode status, Object message, Continuation<? super Unit> continuation) {
        KtorExtendedResponse extendedResponse = new KtorExtendedResponse(call);
        NewRelic.getAgent().getTransaction().setWebResponse(extendedResponse);
        return Weaver.callOriginal();
    }

    @Trace
    public static Object respondRedirect(ApplicationCall call, String url, boolean permanent, Continuation<? super Unit> continuation) {
        KtorExtendedResponse extendedResponse = new KtorExtendedResponse(call);
        NewRelic.getAgent().getTransaction().setWebResponse(extendedResponse);
        return Weaver.callOriginal();
    }

    @Trace
    public static Object respondRedirect(ApplicationCall call, boolean permanent, Function1<? super URLBuilder, Unit> function1, Continuation<? super Unit> continuation) {
        KtorExtendedResponse extendedResponse = new KtorExtendedResponse(call);
        NewRelic.getAgent().getTransaction().setWebResponse(extendedResponse);
        return Weaver.callOriginal();
    }

    @Trace
    public static Object respondText(ApplicationCall call, String text, ContentType contentType, HttpStatusCode status, Function1<? super OutgoingContent, Unit> function1, Continuation<? super Unit> continuation) {
        KtorExtendedResponse extendedResponse = new KtorExtendedResponse(call);
        NewRelic.getAgent().getTransaction().setWebResponse(extendedResponse);
        return Weaver.callOriginal();
    }

    @Trace
    public static Object respondText(ApplicationCall call, ContentType contentType, HttpStatusCode status, Function1<? super Continuation<? super String>, ? extends Object> function1, Continuation<? super Unit> continuation) {
        KtorExtendedResponse extendedResponse = new KtorExtendedResponse(call);
        NewRelic.getAgent().getTransaction().setWebResponse(extendedResponse);
        return Weaver.callOriginal();
    }

    @Trace
    public static Object respondBytes(ApplicationCall call, ContentType contentType, HttpStatusCode status, Function1<? super Continuation<? super byte[]>, ? extends Object> function1, Continuation<? super Unit> continuation) {
        KtorExtendedResponse extendedResponse = new KtorExtendedResponse(call);
        NewRelic.getAgent().getTransaction().setWebResponse(extendedResponse);
        return Weaver.callOriginal();
    }

    @Trace
    public static Object respondBytes(ApplicationCall call, byte[] bytes, ContentType contentType, HttpStatusCode status, Function1<? super OutgoingContent, Unit> function1, Continuation<? super Unit> continuation) {
        KtorExtendedResponse extendedResponse = new KtorExtendedResponse(call);
        NewRelic.getAgent().getTransaction().setWebResponse(extendedResponse);
        return Weaver.callOriginal();
    }

    @Trace
    public static Object respondFile(ApplicationCall call, File baseDir, String file, Function1<? super OutgoingContent, Unit> function1, Continuation<? super Unit> continuation) {
        KtorExtendedResponse extendedResponse = new KtorExtendedResponse(call);
        NewRelic.getAgent().getTransaction().setWebResponse(extendedResponse);
        return Weaver.callOriginal();
    }

    @Trace
    public static Object respondFile(ApplicationCall call, File file, Function1<? super OutgoingContent, Unit> function1, Continuation<? super Unit> continuation) {
        KtorExtendedResponse extendedResponse = new KtorExtendedResponse(call);
        NewRelic.getAgent().getTransaction().setWebResponse(extendedResponse);
        return Weaver.callOriginal();
    }

    @Trace
    public static Object respondTextWriter(ApplicationCall call, ContentType contentType, HttpStatusCode status, Function2<? super Writer, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        KtorExtendedResponse extendedResponse = new KtorExtendedResponse(call);
        NewRelic.getAgent().getTransaction().setWebResponse(extendedResponse);
        return Weaver.callOriginal();
    }

    @Trace
    public static Object respondOutputStream(ApplicationCall call, ContentType contentType, HttpStatusCode status, Function2<? super OutputStream, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        KtorExtendedResponse extendedResponse = new KtorExtendedResponse(call);
        NewRelic.getAgent().getTransaction().setWebResponse(extendedResponse);
        return Weaver.callOriginal();
    }

}
