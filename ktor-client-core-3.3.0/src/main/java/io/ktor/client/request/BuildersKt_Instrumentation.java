package io.ktor.client.request;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import io.ktor.client.HttpClient;
import io.ktor.client.statement.HttpResponse;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import io.ktor.http.Url;

@Weave(originalName = "io.ktor.client.request.BuildersKt")
public class BuildersKt_Instrumentation {

    @Trace(dispatcher = true)
    public static Object request(HttpClient client, HttpRequestBuilder builder, Continuation<? super HttpResponse> continuation) {
        return Weaver.callOriginal();
    }

    @Trace(dispatcher = true)
    public static Object request(HttpClient client, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        return Weaver.callOriginal();
    }

    @Trace(dispatcher = true)
    public static Object request(HttpClient client, String urlString, Function1<? super HttpRequestBuilder, kotlin.Unit> function1,
            Continuation<? super HttpResponse> continuation) {
        return Weaver.callOriginal();
    }

    @Trace(dispatcher = true)
    public static Object request(HttpClient client, Url url, Function1<? super HttpRequestBuilder, Unit> function1,
            Continuation<? super HttpResponse> continuation) {
        return Weaver.callOriginal();
    }

    @Trace(dispatcher = true)
    public static Object get(HttpClient client, HttpRequestBuilder builder, Continuation<? super HttpResponse> continuation) {
        return Weaver.callOriginal();
    }

    @Trace(dispatcher = true)
    public static Object post(HttpClient client, HttpRequestBuilder builder, Continuation<? super HttpResponse> continuation) {
        return Weaver.callOriginal();
    }

    @Trace(dispatcher = true)
    public static Object put(HttpClient client, HttpRequestBuilder builder, Continuation<? super HttpResponse> continuation) {
        return Weaver.callOriginal();
    }

    @Trace(dispatcher = true)
    public static Object delete(HttpClient client, HttpRequestBuilder builder, Continuation<? super HttpResponse> continuation) {
        return Weaver.callOriginal();
    }

    @Trace(dispatcher = true)
    public static Object options(HttpClient client, HttpRequestBuilder builder, Continuation<? super HttpResponse> continuation) {
        return Weaver.callOriginal();
    }

    @Trace(dispatcher = true)
    public static Object patch(HttpClient client, HttpRequestBuilder builder, Continuation<? super HttpResponse> continuation) {
        return Weaver.callOriginal();
    }

    @Trace(dispatcher = true)
    public static Object head(HttpClient client, HttpRequestBuilder builder, Continuation<? super HttpResponse> continuation) {
        return Weaver.callOriginal();
    }

    @Trace(dispatcher = true)
    public static Object get(HttpClient client, Function1<? super HttpRequestBuilder, kotlin.Unit> function1, Continuation<? super HttpResponse> continuation) {
        return Weaver.callOriginal();
    }

    @Trace(dispatcher = true)
    public static Object post(HttpClient client, Function1<? super HttpRequestBuilder, kotlin.Unit> function1,
            Continuation<? super HttpResponse> continuation) {
        return Weaver.callOriginal();
    }

    @Trace(dispatcher = true)
    public static Object put(HttpClient client, Function1<? super HttpRequestBuilder, kotlin.Unit> function1, Continuation<? super HttpResponse> continuation) {
        return Weaver.callOriginal();
    }

    @Trace(dispatcher = true)
    public static Object delete(HttpClient client, Function1<? super HttpRequestBuilder, kotlin.Unit> function1,
            Continuation<? super HttpResponse> continuation) {
        return Weaver.callOriginal();
    }

    @Trace(dispatcher = true)
    public static Object options(HttpClient client, Function1<? super HttpRequestBuilder, kotlin.Unit> function1,
            Continuation<? super HttpResponse> continuation) {
        return Weaver.callOriginal();
    }

    @Trace(dispatcher = true)
    public static Object patch(HttpClient client, Function1<? super HttpRequestBuilder, kotlin.Unit> function1,
            Continuation<? super HttpResponse> continuation) {
        return Weaver.callOriginal();
    }

    @Trace(dispatcher = true)
    public static Object head(HttpClient client, Function1<? super HttpRequestBuilder, kotlin.Unit> function1,
            Continuation<? super HttpResponse> continuation) {
        return Weaver.callOriginal();
    }

    @Trace(dispatcher = true)
    public static Object get(HttpClient client, String urlString, Function1<? super HttpRequestBuilder, kotlin.Unit> function1,
            Continuation<? super HttpResponse> continuation) {
        return Weaver.callOriginal();
    }

    @Trace(dispatcher = true)
    public static Object post(HttpClient client, String urlString, Function1<? super HttpRequestBuilder, kotlin.Unit> function1,
            Continuation<? super HttpResponse> continuation) {
        return Weaver.callOriginal();
    }

    @Trace(dispatcher = true)
    public static Object put(HttpClient client, String urlString, Function1<? super HttpRequestBuilder, kotlin.Unit> function1,
            Continuation<? super HttpResponse> continuation) {
        return Weaver.callOriginal();
    }

    @Trace(dispatcher = true)
    public static Object delete(HttpClient client, String urlString, Function1<? super HttpRequestBuilder, kotlin.Unit> function1,
            Continuation<? super HttpResponse> continuation) {
        return Weaver.callOriginal();
    }

    @Trace(dispatcher = true)
    public static Object options(HttpClient client, String urlString, Function1<? super HttpRequestBuilder, kotlin.Unit> function1,
            Continuation<? super HttpResponse> continuation) {
        return Weaver.callOriginal();
    }

    @Trace(dispatcher = true)
    public static Object patch(HttpClient client, String urlString, Function1<? super HttpRequestBuilder, kotlin.Unit> function1,
            Continuation<? super HttpResponse> continuation) {
        return Weaver.callOriginal();
    }

    @Trace(dispatcher = true)
    public static Object head(HttpClient client, String urlString, Function1<? super HttpRequestBuilder, kotlin.Unit> function1,
            Continuation<? super HttpResponse> continuation) {
        return Weaver.callOriginal();
    }
}
