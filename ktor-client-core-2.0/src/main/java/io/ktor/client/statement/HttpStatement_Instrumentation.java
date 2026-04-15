package io.ktor.client.statement;

import com.newrelic.api.agent.HttpParameters;
import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.NewField;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.ktor.client.KtorClientUtils;
import com.newrelic.instrumentation.labs.ktor.client.KtorHeaderWrapper;
import com.newrelic.instrumentation.labs.ktor.client.NRContinuationWrapper;
import com.newrelic.instrumentation.labs.ktor.client.NRFunction2Wrapper;
import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpMethod;
import io.ktor.http.URLBuilder;
import io.ktor.http.Url;

import java.net.URI;

@Weave(originalName = "io.ktor.client.statement.HttpStatement")
public class HttpStatement_Instrumentation {

    @NewField
    private HttpParameters httpParameters = null;

    public HttpStatement_Instrumentation(HttpRequestBuilder builder, HttpClient client) {
        HeadersBuilder headersBuilder = builder.getHeaders();
        if(headersBuilder != null) {
            KtorHeaderWrapper headerWrapper = new KtorHeaderWrapper(headersBuilder);
            NewRelic.getAgent().getTransaction().insertDistributedTraceHeaders(headerWrapper);
        }
        URLBuilder urlBuilder = builder.getUrl();
        if(urlBuilder != null) {
            Url url = urlBuilder.build();
            String urlString = url.toString();
            if(urlString != null) {
                HttpMethod method = builder.getMethod();
                URI uri = URI.create(urlString);
                httpParameters = HttpParameters.library("Ktor-Client").uri(uri).procedure(method.getValue()).noInboundHeaders().build();
            }
        }
    }

    @Trace(dispatcher = true)
    public <T> java.lang.Object execute(kotlin.jvm.functions.Function2<? super io.ktor.client.statement.HttpResponse, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> function2, kotlin.coroutines.Continuation<? super T> continuation) {
        if(!(function2 instanceof NRFunction2Wrapper)) {
            function2 = new NRFunction2Wrapper<>(function2);
        }
        return Weaver.callOriginal();
    }

    @Trace(dispatcher = true)
    public java.lang.Object execute(kotlin.coroutines.Continuation<? super io.ktor.client.statement.HttpResponse> continuation) {
        NRContinuationWrapper<? super HttpResponse> wrapper = KtorClientUtils.getContinuationWrapper(continuation, httpParameters);
        if(wrapper != null) {
            continuation =  wrapper;
        }
        return Weaver.callOriginal();
    }

    @Trace(dispatcher = true)
    public java.lang.Object executeUnsafe(kotlin.coroutines.Continuation<? super io.ktor.client.statement.HttpResponse> continuation) {
        return Weaver.callOriginal();
    }

}
