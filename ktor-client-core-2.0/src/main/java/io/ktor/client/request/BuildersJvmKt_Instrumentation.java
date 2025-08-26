package io.ktor.client.request;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TracedMethod;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import io.ktor.client.HttpClient;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.coroutines.Continuation;
import java.net.URL;

@Weave(originalName = "io.ktor.client.request.BuildersJvmKt")
public class BuildersJvmKt_Instrumentation {

    @Trace(dispatcher = true)
    public static  Object request(HttpClient client, URL url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        TracedMethod traced = NewRelic.getAgent().getTracedMethod();
        traced.setMetricName(new String[] {"Custom","KtorClient","request"});
        traced.addCustomAttribute("Method", "Request");
        traced.addCustomAttribute("URL", url.toString());
        return Weaver.callOriginal();
    }

    @Trace(dispatcher = true)
    public static  Object get(HttpClient client, URL url, Function1<? super HttpRequestBuilder, kotlin.Unit> function1, Continuation<? super HttpResponse> continuation) {
        TracedMethod traced = NewRelic.getAgent().getTracedMethod();
        traced.setMetricName(new String[] {"Custom","KtorClient","get"});
        traced.addCustomAttribute("Method", "Get");
        traced.addCustomAttribute("URL", url.toString());
        return Weaver.callOriginal();
    }

    @Trace(dispatcher = true)
    public static  Object post(HttpClient client, URL url, Function1<? super HttpRequestBuilder, kotlin.Unit> function1, Continuation<? super HttpResponse> continuation) {
        TracedMethod traced = NewRelic.getAgent().getTracedMethod();
        traced.setMetricName(new String[] {"Custom","KtorClient","post"});
        traced.addCustomAttribute("Method", "Post");
        traced.addCustomAttribute("URL", url.toString());
        return Weaver.callOriginal();
    }

    @Trace(dispatcher = true)
    public static  Object put(HttpClient client, URL url, Function1<? super HttpRequestBuilder, kotlin.Unit> function1, Continuation<? super HttpResponse> continuation ) {
        TracedMethod traced = NewRelic.getAgent().getTracedMethod();
        traced.setMetricName(new String[] {"Custom","KtorClient","put"});
        traced.addCustomAttribute("Method", "Put");
        traced.addCustomAttribute("URL", url.toString());
        return Weaver.callOriginal();
    }

    @Trace(dispatcher = true)
    public static  Object patch(HttpClient client, URL url, Function1<? super HttpRequestBuilder, kotlin.Unit> function1, Continuation<? super HttpResponse> continuation) {
        TracedMethod traced = NewRelic.getAgent().getTracedMethod();
        traced.setMetricName(new String[] {"Custom","KtorClient","patch"});
        traced.addCustomAttribute("Method", "Patch");
        traced.addCustomAttribute("URL", url.toString());
        return Weaver.callOriginal();
    }

    @Trace(dispatcher = true)
    public static  Object options(HttpClient client, URL url, Function1<? super HttpRequestBuilder, kotlin.Unit> function1, Continuation<? super HttpResponse> continuation) {
        TracedMethod traced = NewRelic.getAgent().getTracedMethod();
        traced.setMetricName(new String[] {"Custom","KtorClient","options"});
        traced.addCustomAttribute("Method", "Options");
        traced.addCustomAttribute("URL", url.toString());
        return Weaver.callOriginal();
    }

    @Trace(dispatcher = true)
    public static  Object head(HttpClient client, URL url, Function1<? super HttpRequestBuilder, kotlin.Unit> function1, Continuation<? super HttpResponse> continuation) {
        TracedMethod traced = NewRelic.getAgent().getTracedMethod();
        traced.setMetricName(new String[] {"Custom","KtorClient","head"});
        traced.addCustomAttribute("Method", "Head");
        traced.addCustomAttribute("URL", url.toString());
        return Weaver.callOriginal();
    }

    @Trace(dispatcher = true)
    public static  Object delete(HttpClient client, URL url, Function1<? super HttpRequestBuilder, kotlin.Unit> function1, Continuation<? super HttpResponse> continuation) {
        TracedMethod traced = NewRelic.getAgent().getTracedMethod();
        traced.setMetricName(new String[] {"Custom","KtorClient","delete"});
        traced.addCustomAttribute("Method", "Delete");
        traced.addCustomAttribute("URL", url.toString());
        return Weaver.callOriginal();
    }

}
