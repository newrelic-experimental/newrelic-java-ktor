package io.netty.util.concurrent;

import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.netty.eventloop.NRRunnable;
import com.newrelic.instrumentation.labs.netty.eventloop.Utils;

@Weave(type = MatchType.BaseClass)
public abstract class SingleThreadEventExecutor {

	
	public void execute(Runnable task) {
		NRRunnable wrapper = Utils.getWrapper(task);
		if(wrapper != null) {
			task = wrapper;
		}
		Weaver.callOriginal();
	}
	
	protected boolean removeTask(Runnable task) {
		if(task instanceof NRRunnable) {
			((NRRunnable)task).cancel();
		}
		
		return Weaver.callOriginal();
	}
}
