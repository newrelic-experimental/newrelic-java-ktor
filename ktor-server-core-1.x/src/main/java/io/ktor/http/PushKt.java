package io.ktor.http;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import io.ktor.application.ApplicationCall;
import io.ktor.response.ResponsePushBuilder;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Weave
public class PushKt {

	@Trace(dispatcher = true)
	public static void push(ApplicationCall call, String pathAndQuery) {
		Weaver.callOriginal();
	}

	@Trace(dispatcher = true)
	public static void push(ApplicationCall call, String encodedPath, Parameters parameters) {
		Weaver.callOriginal();
	}

	@Trace(dispatcher = true)
	public static void push(ApplicationCall call, Function1<? super ResponsePushBuilder, Unit> f) {
		Weaver.callOriginal();
	}


}
