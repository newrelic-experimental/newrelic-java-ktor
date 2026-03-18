package io.ktor.client.engine.cio;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.ktor.cio.client.InstrumentationUtils;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpResponseData;
import io.ktor.util.date.GMTDate;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

@Weave(originalName = "io.ktor.client.engine.cio.UtilsKt")
public class UtilsKt_Instrumentation {

    @Trace(dispatcher = true)
    public static Object write(HttpRequestData requestData, ByteWriteChannel writeChannel, CoroutineContext coroutineContext, boolean overProxy, boolean closeChannel, Continuation<? super Unit> continuation) {
        if(!InstrumentationUtils.initialized) {
            InstrumentationUtils.init();
        }
        return Weaver.callOriginal();
    }

    @Trace(dispatcher = true)
    public static Object readResponse(GMTDate date, HttpRequestData requestData, ByteReadChannel readChannel, ByteWriteChannel writeChannel, CoroutineContext coroutineContext, Continuation<? super HttpResponseData> continuation) {
        if(!InstrumentationUtils.initialized) {
            InstrumentationUtils.init();
        }
        return Weaver.callOriginal();
    }
}
