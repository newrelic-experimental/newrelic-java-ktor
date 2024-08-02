package io.netty.util.concurrent;

import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.netty.eventloop.NRRunnable;
import com.newrelic.instrumentation.labs.netty.eventloop.Utils;

@Weave
public class ThreadPerTaskExecutor {

	
	public void execute(Runnable command) {
//		NRRunnable wrapper = Utils.getWrapper(command);
//		if(wrapper != null) {
//			command = wrapper;
//		}
		Weaver.callOriginal();
	}
}
