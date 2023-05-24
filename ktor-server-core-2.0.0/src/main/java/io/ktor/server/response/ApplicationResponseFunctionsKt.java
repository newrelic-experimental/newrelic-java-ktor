package io.ktor.server.response;

import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import io.ktor.http.ContentType;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.URLBuilder;
import io.ktor.http.content.OutgoingContent;
import io.ktor.server.application.ApplicationCall;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Weave
public class ApplicationResponseFunctionsKt {


	public static Object respondRedirect(ApplicationCall call, String url, boolean permanent, Continuation<? super Unit> continuation) {
		return Weaver.callOriginal();
	}

	public static Object respondRedirect(ApplicationCall call, boolean permanent, Function1<? super URLBuilder, Unit> f, Continuation<? super Unit> continuation) {
		return Weaver.callOriginal();
	}

	public static Object respondText(ApplicationCall call, String text, ContentType contextType, HttpStatusCode code, Function1<? super io.ktor.http.content.OutgoingContent, Unit> f, Continuation<? super Unit> continuation) {
		return Weaver.callOriginal();
	}

	public static Object respondText(ApplicationCall call, ContentType contextType, HttpStatusCode code, Function1<? super Continuation<? super String>, ? extends Object> f, Continuation<? super Unit> continuation) {
		return Weaver.callOriginal();
	}

	public static Object respondBytes(ApplicationCall call, ContentType contextType, HttpStatusCode code, Function1<? super Continuation<? super byte[]>, ? extends Object> f, Continuation<? super Unit> continuation) {
		return Weaver.callOriginal();
	}

	public static Object respondBytes(ApplicationCall call, byte[] bytes, ContentType contextType, HttpStatusCode code, Function1<? super OutgoingContent, Unit> f, Continuation<? super Unit> continuation) {
		return Weaver.callOriginal();
	}

}
