package io.ktor.client.request;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import io.ktor.client.HttpClient;
import io.ktor.http.Url;
import kotlin.jvm.functions.Function1;
import kotlin.coroutines.Continuation;
import io.ktor.client.statement.HttpResponse;

import java.util.logging.Level;

@Weave(originalName = "io.ktor.client.request.BuildersWithUrlKt")
public class BuildersWithUrlKt_Instrumentation {

    @Trace
    public static Object get(HttpClient client, Url url, Function1<? super HttpRequestBuilder, kotlin.Unit> function1, Continuation<? super HttpResponse> continuation) {
        NewRelic.getAgent().getLogger().log(Level.FINE,"Call to BuildersWithUrlKt.get({0},{1},{2},{3})",client, url,function1,continuation);
        return Weaver.callOriginal();
    }

    @Trace
    public static Object post(HttpClient client, Url url, Function1<? super HttpRequestBuilder, kotlin.Unit> function1, Continuation<? super HttpResponse> continuation) {
        NewRelic.getAgent().getLogger().log(Level.FINE,"Call to BuildersWithUrlKt.post({0},{1},{2},{3})",client, url,function1,continuation);
        return Weaver.callOriginal();
    }

    public static Object put(HttpClient client, Url url, Function1<? super HttpRequestBuilder, kotlin.Unit> function1, Continuation<? super HttpResponse> continuation) {
        NewRelic.getAgent().getLogger().log(Level.FINE,"Call to BuildersWithUrlKt.put({0},{1},{2},{3})",client, url,function1,continuation);
        return Weaver.callOriginal();
    }

    public static Object patch(HttpClient client, Url url, Function1<? super HttpRequestBuilder, kotlin.Unit> function1, Continuation<? super HttpResponse> continuation) {
        NewRelic.getAgent().getLogger().log(Level.FINE,"Call to BuildersWithUrlKt.patch({0},{1},{2},{3})",client, url,function1,continuation);
        return Weaver.callOriginal();
    }

    public static Object options(HttpClient client, Url url, Function1<? super HttpRequestBuilder, kotlin.Unit> function1, Continuation<? super HttpResponse> continuation) {
        NewRelic.getAgent().getLogger().log(Level.FINE,"Call to BuildersWithUrlKt.options({0},{1},{2},{3})",client, url,function1,continuation);
        return Weaver.callOriginal();
    }

    public static Object head(HttpClient client, Url url, Function1<? super HttpRequestBuilder, kotlin.Unit> function1, Continuation<? super HttpResponse> continuation) {
        NewRelic.getAgent().getLogger().log(Level.FINE,"Call to BuildersWithUrlKt.head({0},{1},{2},{3})",client, url,function1,continuation);
        return Weaver.callOriginal();
    }

    public static Object delete(HttpClient client, Url url, Function1<? super HttpRequestBuilder, kotlin.Unit> function1, Continuation<? super HttpResponse> continuation) {
        NewRelic.getAgent().getLogger().log(Level.FINE,"Call to BuildersWithUrlKt.delete({0},{1},{2},{3})",client, url,function1,continuation);
        return Weaver.callOriginal();
    }

}
