package io.ktor.client.request;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import io.ktor.client.HttpClient;
import io.ktor.http.Url;
import kotlin.jvm.functions.Function1;
import kotlin.coroutines.Continuation;
import io.ktor.client.statement.HttpResponse;

@Weave(originalName = "io.ktor.client.request.BuildersWithUrlKt")
public class BuildersWithUrlKt_Instrumentation {

    @Trace(dispatcher = true)
    public static Object get(HttpClient client, Url url, Function1<? super HttpRequestBuilder, kotlin.Unit> function1, Continuation<? super HttpResponse> continuation) {
        return Weaver.callOriginal();
    }

    @Trace(dispatcher = true)
    public static Object post(HttpClient client, Url url, Function1<? super HttpRequestBuilder, kotlin.Unit> function1, Continuation<? super HttpResponse> continuation) {
        return Weaver.callOriginal();
    }

    @Trace(dispatcher = true)
    public static Object put(HttpClient client, Url url, Function1<? super HttpRequestBuilder, kotlin.Unit> function1, Continuation<? super HttpResponse> continuation) {
        return Weaver.callOriginal();
    }

    @Trace(dispatcher = true)
    public static Object patch(HttpClient client, Url url, Function1<? super HttpRequestBuilder, kotlin.Unit> function1, Continuation<? super HttpResponse> continuation) {
        return Weaver.callOriginal();
    }

    @Trace(dispatcher = true)
    public static Object options(HttpClient client, Url url, Function1<? super HttpRequestBuilder, kotlin.Unit> function1, Continuation<? super HttpResponse> continuation) {
        return Weaver.callOriginal();
    }

    @Trace(dispatcher = true)
    public static Object head(HttpClient client, Url url, Function1<? super HttpRequestBuilder, kotlin.Unit> function1, Continuation<? super HttpResponse> continuation) {
        return Weaver.callOriginal();
    }

    @Trace(dispatcher = true)
    public static Object delete(HttpClient client, Url url, Function1<? super HttpRequestBuilder, kotlin.Unit> function1, Continuation<? super HttpResponse> continuation) {
        return Weaver.callOriginal();
    }

}
