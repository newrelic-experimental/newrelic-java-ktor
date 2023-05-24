package io.ktor.client.call;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

@Weave
public abstract class UtilsKt {

	@Trace
	public static Object call(HttpClient $receiver, HttpRequestBuilder builder, Continuation<? super HttpClientCall> var2) {
		return Weaver.callOriginal();
	}

	@Trace
	public static Object call(HttpClient $receiver, String urlString, Function2<? super HttpRequestBuilder, ? super Continuation<? super Unit>, ? extends Object> block, Continuation<? super HttpClientCall> var3) {
		return Weaver.callOriginal();
	}
}	   
