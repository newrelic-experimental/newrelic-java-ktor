package io.ktor.client.engine.cio;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Token;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.ktor.cio.NRTokenContextKt;
import com.newrelic.instrumentation.labs.ktor.cio.TokenContext;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpResponseData;
import io.ktor.util.date.GMTDate;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

import java.util.logging.Level;

@Weave(originalName = "io.ktor.client.engine.cio.UtilsKt")
public class UtilsKt_Instrumentation {

    @Trace(dispatcher = true)
    public static Object writeRequest(HttpRequestData requestData, ByteWriteChannel writeChannel, CoroutineContext coroutineContext, boolean overProxy, boolean closeChannel, Continuation<? super Unit> continuation) {
        NewRelic.getAgent().getLogger().log(Level.FINER, new Exception("call to writeRequest"),"Writing request : {0}", requestData);
//        TokenContext tokenContext = NRTokenContextKt.getTokenContextOrNull(coroutineContext);
//        if(tokenContext == null) {
//            Token token = NewRelic.getAgent().getTransaction().getToken();
//            if(token != null) {
//                if(token.isActive()) {
//                    NRTokenContextKt.addTokenContext(coroutineContext, token);
//                } else {
//                    token.expire();
//                    token = null;
//                }
//            }
//        }
        return Weaver.callOriginal();
    }

    @Trace(dispatcher = true)
    public static Object readResponse(GMTDate date, HttpRequestData requestData, ByteReadChannel readChannel, ByteWriteChannel writeChannel, CoroutineContext coroutineContext, Continuation<? super HttpResponseData> continuation) {
        NewRelic.getAgent().getLogger().log(Level.FINER, new Exception("call to readResponse"),"Reading response for : {0}", requestData);
//        TokenContext tokenContext = NRTokenContextKt.getTokenContextOrNull(coroutineContext);
//        if(tokenContext != null) {
//            Token token = tokenContext.getToken();
//            token.linkAndExpire();
//            token = null;
//            NRTokenContextKt.removeTokenContext(coroutineContext);
//        }
        return Weaver.callOriginal();
    }
}
