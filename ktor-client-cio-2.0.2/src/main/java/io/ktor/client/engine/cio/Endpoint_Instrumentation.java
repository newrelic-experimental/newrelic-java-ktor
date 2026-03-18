package io.ktor.client.engine.cio;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.ktor.cio.KtorClientCIOUtils;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpResponseData;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

@Weave(originalName = "io.ktor.client.engine.cio.Endpoint")
public class Endpoint_Instrumentation {

    @Trace
    public Object execute(HttpRequestData request, CoroutineContext coroutineContext, Continuation<? super HttpResponseData> continuation) {
        if(!KtorClientCIOUtils.initialized) {
            KtorClientCIOUtils.init();
        }
        return Weaver.callOriginal();
    }

}
