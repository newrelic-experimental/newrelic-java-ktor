package io.ktor.client.call;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import kotlin.coroutines.Continuation;

@Weave
public abstract class HttpClientCall {

	@Trace(dispatcher = true)
	public Object receive(TypeInfo info, Continuation<Object> $completion){
		return Weaver.callOriginal();
	}
}
