package io.netty.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.netty.eventloop.NRCallable;
import com.newrelic.instrumentation.labs.netty.eventloop.NRRunnable;
import com.newrelic.instrumentation.labs.netty.eventloop.Utils;

@Weave(type=MatchType.BaseClass)
public abstract class AbstractEventExecutor {

	
	public ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit) {
		NRRunnable wrapper = Utils.getWrapper(command);
		if(wrapper != null) {
			command = wrapper;
		}	
		return Weaver.callOriginal();
	}
	
	public <V> ScheduledFuture<V> schedule(Callable<V> callable, long delay, TimeUnit unit) {
		NRCallable<V> wrapper = Utils.getWrapper(callable);
		if(wrapper != null) {
			callable = wrapper;
		}
		return Weaver.callOriginal();
	}
}
