package io.ktor.client.call;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.Url;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

@Weave(originalName = "io.ktor.client.call.UtilsKt")
public class UtilsKt_Instrumentation {

    @Trace
    public static Object call(HttpClient client, HttpRequestBuilder builder, Continuation<? super HttpClientCall> continuation) {
        String url = builder.getUrl().buildString();
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("URL", url);
        return Weaver.callOriginal();
    };

    @Trace
    public static Object call(HttpClient client, String urlString, Function2<? super HttpRequestBuilder, ? super Continuation<? super Unit>, Object> function2, Continuation<? super HttpClientCall> continuation) {
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("URL", urlString);
        return Weaver.callOriginal();
    }

    @Trace
    public static Object call(HttpClient client, Url url, Function2<? super HttpRequestBuilder, ? super Continuation<? super Unit>, Object> function2, Continuation<? super HttpClientCall> continuation) {
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("URL", url.toString());
        return Weaver.callOriginal();
    };
}
