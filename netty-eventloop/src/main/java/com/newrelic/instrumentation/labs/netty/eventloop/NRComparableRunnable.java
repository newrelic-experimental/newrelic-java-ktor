package com.newrelic.instrumentation.labs.netty.eventloop;

import com.newrelic.agent.bridge.AgentBridge;
import com.newrelic.api.agent.Token;

public class NRComparableRunnable<T> extends NRRunnable implements Comparable<T> {
	
	private Comparable<T> delegate2 = null;
	private static boolean isTransformed = false;
	
	@SuppressWarnings("unchecked")
	public NRComparableRunnable(Runnable r,Token t) {
		super(r,t);
		if(r instanceof Comparable) {
			delegate2 = (Comparable<T>)r;
		}
		if(!isTransformed) {
			AgentBridge.instrumentation.retransformUninstrumentedClass(getClass());
			isTransformed = true;
		}
	}

	public void cancel() {
		if(token != null) {
			token.expire();
			token = null;
		}
	}

	@Override
	public int compareTo(T o) {
		if(delegate2 != null) {
			return delegate2.compareTo(o);
		}
		return 0;
	}
}
