package com.newrelic.instrumentation.labs.netty.eventloop;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.newrelic.agent.bridge.AgentBridge;
import com.newrelic.api.agent.Token;

public class NRRunnableFuture<T> extends NRRunnable implements RunnableFuture<T> {
	
	private RunnableFuture<T> delegate = null;
	private static boolean isTransformed = false;

	public NRRunnableFuture(RunnableFuture<T> delegate, Token token) {
		super(delegate, token);
		this.delegate = delegate;
		this.token = token;
		if(!isTransformed) {
			isTransformed = true;
			AgentBridge.instrumentation.retransformUninstrumentedClass(getClass());
		}
	}

	@Override
	public boolean cancel(boolean mayInterruptIfRunning) {
		return delegate != null ? delegate.cancel(mayInterruptIfRunning) : false;
	}

	@Override
	public boolean isCancelled() {
		return delegate != null ? delegate.isCancelled() : false;
	}

	@Override
	public boolean isDone() {
		return delegate != null ? delegate.isDone() : true;
	}

	@Override
	public T get() throws InterruptedException, ExecutionException {
		return delegate != null ? delegate.get() : null;
	}

	@Override
	public T get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
		return delegate != null ? delegate.get(timeout, unit) : null;
	}


}
