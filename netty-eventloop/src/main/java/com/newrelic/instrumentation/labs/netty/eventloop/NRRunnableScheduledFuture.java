package com.newrelic.instrumentation.labs.netty.eventloop;

import java.util.concurrent.Delayed;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.TimeUnit;

import com.newrelic.agent.bridge.AgentBridge;
import com.newrelic.api.agent.Token;

public class NRRunnableScheduledFuture<V> extends NRRunnableFuture<V> implements RunnableScheduledFuture<V> {
	
	private RunnableScheduledFuture<V> delegate = null;
	private static boolean isTransformed = false;
	
	public NRRunnableScheduledFuture(RunnableScheduledFuture<V> d, Token t) {
		super(d,t);
		delegate = d;
		token = t;
		if(!isTransformed) {
			isTransformed = true;
			AgentBridge.instrumentation.retransformUninstrumentedClass(getClass());
		}
	}

	@Override
	public long getDelay(TimeUnit unit) {
		return delegate != null ? delegate.getDelay(unit) : 0;
	}

	@Override
	public int compareTo(Delayed o) {
		return delegate != null ? delegate.compareTo(o) : 0;
	}

	@Override
	public boolean isPeriodic() {
		return delegate != null ? delegate.isPeriodic() : false;
	}


}
