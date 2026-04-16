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
import java.util.logging.Level;

@Weave(originalName = "io.ktor.client.request.BuildersJvmKt")
public class BuildersJvmKt_Instrumentation {

    @Trace
    public static  Object request(HttpClient client, URL url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        NewRelic.getAgent().getLogger().log(Level.FINE,"Call to BuildersJvmKt.request({0},{1},{2}",url,function1,continuation);
        return Weaver.callOriginal();
    }

    @Trace
    public static  Object get(HttpClient client, URL url, Function1<? super HttpRequestBuilder, kotlin.Unit> function1, Continuation<? super HttpResponse> continuation) {
        NewRelic.getAgent().getLogger().log(Level.FINE,"Call to BuildersJvmKt.get({0},{1},{2}",url,function1,continuation);
        return Weaver.callOriginal();
    }

    public static  Object post(HttpClient client, URL url, Function1<? super HttpRequestBuilder, kotlin.Unit> function1, Continuation<? super HttpResponse> continuation) {
        NewRelic.getAgent().getLogger().log(Level.FINE,"Call to BuildersJvmKt.post({0},{1},{2}",url,function1,continuation);
        return Weaver.callOriginal();
    }

    public static  Object put(HttpClient client, URL url, Function1<? super HttpRequestBuilder, kotlin.Unit> function1, Continuation<? super HttpResponse> continuation ) {
        NewRelic.getAgent().getLogger().log(Level.FINE,"Call to BuildersJvmKt.put({0},{1},{2}",url,function1,continuation);
        return Weaver.callOriginal();
    }

    public static  Object patch(HttpClient client, URL url, Function1<? super HttpRequestBuilder, kotlin.Unit> function1, Continuation<? super HttpResponse> continuation) {
        NewRelic.getAgent().getLogger().log(Level.FINE,"Call to BuildersJvmKt.patch({0},{1},{2}",url,function1,continuation);
        return Weaver.callOriginal();
    }

    public static  Object options(HttpClient client, URL url, Function1<? super HttpRequestBuilder, kotlin.Unit> function1, Continuation<? super HttpResponse> continuation) {
        NewRelic.getAgent().getLogger().log(Level.FINE,"Call to BuildersJvmKt.options({0},{1},{2}",url,function1,continuation);
        return Weaver.callOriginal();
    }

    public static  Object head(HttpClient client, URL url, Function1<? super HttpRequestBuilder, kotlin.Unit> function1, Continuation<? super HttpResponse> continuation) {
        NewRelic.getAgent().getLogger().log(Level.FINE,"Call to BuildersJvmKt.head({0},{1},{2}",url,function1,continuation);
        return Weaver.callOriginal();
    }

    public static  Object delete(HttpClient client, URL url, Function1<? super HttpRequestBuilder, kotlin.Unit> function1, Continuation<? super HttpResponse> continuation) {
        NewRelic.getAgent().getLogger().log(Level.FINE,"Call to BuildersJvmKt.delete({0},{1},{2}",url,function1,continuation);
        return Weaver.callOriginal();
    }

}
