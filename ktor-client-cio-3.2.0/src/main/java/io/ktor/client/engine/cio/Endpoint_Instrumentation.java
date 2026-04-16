package io.ktor.client.engine.cio;

import com.newrelic.api.agent.*;
import com.newrelic.api.agent.weaver.NewField;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.sun.jndi.toolkit.url.UrlUtil;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpResponseData;
import io.ktor.client.request.UnixSocketSettings;
import io.ktor.http.Url;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

import java.net.Proxy;
import java.net.URI;

import kotlin.jvm.functions.Function0;

@Weave(originalName = "io.ktor.client.engine.cio.Endpoint")
public class Endpoint_Instrumentation {

    @NewField
    private Segment segment = null;

    public Endpoint_Instrumentation(String host, int port, Proxy proxy, boolean secure, CIOEngineConfig config, ConnectionFactory connectionFactory,
                                    CoroutineContext coroutineContext, Function0<Unit> onDone, UnixSocketSettings unixSocketSettings) {

    }

    @Trace
    public Object execute(HttpRequestData request, CoroutineContext coroutineContext, Continuation<? super HttpResponseData> continuation) {
//        if (request != null && segment == null) {
//            Url url = request.getUrl();
//            String urlString = null;
//            if (url != null) {
//                urlString = url.toString();
//                URI uri = URI.create(url.toString());
//                HttpParameters httpParameters = HttpParameters.library("Ktor-CIO-Client").uri(uri).procedure(request.getMethod().toString()).noInboundHeaders().build();
//                segment = NewRelic.getAgent().getTransaction().startSegment("CIOClientRequest");
//                segment.reportAsExternal(httpParameters);
//            }
//        }
        return Weaver.callOriginal();
    }

    @Trace
    private Object makePipelineRequest(RequestTask requestTask, Continuation<? super Unit> continuation) {
        return Weaver.callOriginal();
    }

    @Trace
    private Object makeDedicatedRequest(HttpRequestData requestData, CoroutineContext coroutineContext, Continuation<? super HttpResponseData> continuation) {
        return Weaver.callOriginal();
    }

    @Trace(dispatcher = true)
    public void close() {
        if (segment != null) {
            segment.end();
            segment = null;
        }
        Weaver.callOriginal();
    }
}
