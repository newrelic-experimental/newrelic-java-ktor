package io.ktor.server.netty;

import com.newrelic.api.agent.Token;
import com.newrelic.api.agent.weaver.NewField;
import com.newrelic.api.agent.weaver.Weave;

import io.ktor.server.application.Application;
import io.netty.channel.ChannelHandlerContext;


@Weave
public class NettyApplicationCall {

	@NewField
	public Token token = null;
	
	public NettyApplicationCall(Application application, ChannelHandlerContext context, Object requestMessage) {
		
	}
}
