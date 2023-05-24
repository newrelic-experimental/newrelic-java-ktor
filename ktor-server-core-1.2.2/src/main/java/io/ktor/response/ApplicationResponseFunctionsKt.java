package io.ktor.response;

import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import io.ktor.application.ApplicationCall;
import kotlin.coroutines.Continuation;
import io.ktor.http.HttpStatusCode;
import kotlin.jvm.functions.Function1;
import kotlin.Unit;
import io.ktor.http.ContentType;
import io.ktor.http.URLBuilder;
import io.ktor.http.content.OutgoingContent;
import kotlin.jvm.functions.Function2;

@Weave
public class ApplicationResponseFunctionsKt {


	public static Object respond(ApplicationCall call, Object obj, Continuation<? super Unit> continuation) {
		return Weaver.callOriginal();
	}

	public static Object respond(ApplicationCall call,HttpStatusCode code, Object obj, Continuation<? super Unit> continuation) {
		return Weaver.callOriginal();
	}

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

	public static Object respondFile(ApplicationCall call, java.io.File file, String fileName, Function1<? super OutgoingContent, Unit> f, Continuation<? super Unit> continuation) {
		return Weaver.callOriginal();
	}

	public static Object respondFile(ApplicationCall call, java.io.File file, Function1<? super OutgoingContent, Unit> f, Continuation<? super Unit> continuation) {
		return Weaver.callOriginal();
	}

	public static Object respondTextWriter(ApplicationCall call, ContentType contextType, HttpStatusCode code, Function2<? super java.io.Writer, ? super Continuation<? super Unit>, ? extends Object> f, Continuation<? super Unit> continuation) {
		return Weaver.callOriginal();
	}

	public static Object respondOutputStream(ApplicationCall call, ContentType contextType, HttpStatusCode code, Function2<? super java.io.OutputStream, ? super Continuation<? super Unit>, ? extends Object> f, Continuation<? super Unit> continuation)  {
		return Weaver.callOriginal();
	}

}
