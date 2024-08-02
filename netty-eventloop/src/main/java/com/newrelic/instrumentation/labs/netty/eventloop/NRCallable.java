package com.newrelic.instrumentation.labs.netty.eventloop;

import java.util.concurrent.Callable;

import com.newrelic.agent.bridge.AgentBridge;
import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Token;
import com.newrelic.api.agent.Trace;

public class NRCallable<V> implements Callable<V> {
	
	private Callable<V> delegate = null;
	
	private Token token = null;
	private static boolean isTransformed = false;
	
	public NRCallable(Callable<V> c, Token t) {
		delegate = c;
		token = t;
		if(!isTransformed) {
			AgentBridge.instrumentation.retransformUninstrumentedClass(getClass());
			isTransformed = true;
		}
	}

	@Override
	@Trace(async=true,excludeFromTransactionTrace=true)
	public V call() throws Exception {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Executors","Submitted-Callable");
		if(token != null) {
			token.linkAndExpire();
			token = null;
		}
		return delegate.call();
	}

}
