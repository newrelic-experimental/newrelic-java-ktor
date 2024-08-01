package io.ktor.server.servlet;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(type = MatchType.BaseClass)
public abstract class KtorServlet {

	@Trace
	protected void service(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) {
		Weaver.callOriginal();
	}

	 @Trace
	 private void asyncService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) {
		 NewRelic.getAgent().getTracedMethod().setMetricName("Custom","KtorServlet","asyncService");
		 Weaver.callOriginal();
	 }
	 
	 @Trace
	 private final void blockingService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) {
		 NewRelic.getAgent().getTracedMethod().setMetricName("Custom","KtorServlet","blockingService");
		 Weaver.callOriginal();
	 }
}
