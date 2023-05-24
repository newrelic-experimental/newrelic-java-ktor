package io.ktor.client.call;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import io.ktor.util.reflect.TypeInfo;
import kotlin.coroutines.Continuation;

@Weave
public abstract class HttpClientCall {

	@Trace(dispatcher = true)
	public Object body(TypeInfo info, Continuation<Object> $completion){
		return Weaver.callOriginal();
	}
}
