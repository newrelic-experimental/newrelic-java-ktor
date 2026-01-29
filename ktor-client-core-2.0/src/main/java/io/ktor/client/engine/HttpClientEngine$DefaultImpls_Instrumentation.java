package io.ktor.client.engine;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpResponseData;
import kotlin.coroutines.Continuation;

@Weave(originalName = "io.ktor.client.engine.HttpClientEngine$DefaultImpls")
public class HttpClientEngine$DefaultImpls_Instrumentation {

    @Trace(dispatcher = true)
    private static Object executeWithinCallContext(HttpClientEngine engine, HttpRequestData requestData, Continuation<? super HttpResponseData>  continuation) {
        Object ctx = Weaver.callOriginal();

        return ctx;
    }

}
