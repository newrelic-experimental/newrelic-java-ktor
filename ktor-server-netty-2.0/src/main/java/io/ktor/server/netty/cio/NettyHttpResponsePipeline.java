package io.ktor.server.netty.cio;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Token;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import io.ktor.server.netty.NettyApplicationCall;

@Weave
public abstract class NettyHttpResponsePipeline {

	@Trace(async = true)
	private void handleRequestMessage(NettyApplicationCall call) {
		if(call.token != null) {
			call.token.linkAndExpire();
			call.token = null;
		}
		Weaver.callOriginal();
	}

	@Trace
	public void processResponse$ktor_server_netty(NettyApplicationCall call) {
		if(call.token == null) {
			Token t = NewRelic.getAgent().getTransaction().getToken();
			if(t != null && t.isActive()) {
				call.token = t;
			} else if(t != null) {
				t.expire();
				t = null;
			}
		}
		Weaver.callOriginal();
	}
	
}