package io.ktor.client.engine.cio;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpResponseData;
import kotlin.coroutines.Continuation;

@Weave(originalName = "io.ktor.client.engine.cio.CIOEngine")
public class CIOEngine_Instrumentation {

    @Trace(dispatcher = true)
    public Object execute(HttpRequestData requestData, Continuation<? super HttpResponseData>  continuation) {
        return Weaver.callOriginal();
    }

    @Trace(dispatcher = true)
    public void close() {
        Weaver.callOriginal();
    }

}
