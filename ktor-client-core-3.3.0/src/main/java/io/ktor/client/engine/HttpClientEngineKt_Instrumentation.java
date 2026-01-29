package io.ktor.client.engine;

import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.ktor.client.InstrumentationUtils;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.Job;

@Weave(originalName = "io.ktor.client.engine.HttpClientEngineKt")
public class HttpClientEngineKt_Instrumentation {

    public static Object createCallContext(HttpClientEngine engine, Job job, Continuation<? super CoroutineContext> continuation) {
        Object ctx = Weaver.callOriginal();
//        if(ctx instanceof CoroutineContext) {
//            CoroutineContext coroutineContext = (CoroutineContext) ctx;
//            InstrumentationUtils.setToken(coroutineContext);
//        }
        return ctx;
    };

}
