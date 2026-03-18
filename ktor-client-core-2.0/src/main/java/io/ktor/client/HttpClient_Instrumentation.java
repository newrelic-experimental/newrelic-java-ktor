package io.ktor.client;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.ktor.client.InstrumentationUtils;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import kotlin.coroutines.Continuation;

/*
* need to do this one in Java because the execute method is internal and it is
* hard to get it to compile correctly in kotlin
*/
@Weave(originalName = "io.ktor.client.HttpClient")
public class HttpClient_Instrumentation {

    @Trace(dispatcher = true)
    public Object execute$ktor_client_core(HttpRequestBuilder requestBuilder, Continuation<? super HttpClientCall> continuation) {
        if(!InstrumentationUtils.initialized) {
            InstrumentationUtils.init();
        }
        return Weaver.callOriginal();
    }
}
