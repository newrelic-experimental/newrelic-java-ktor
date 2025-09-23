package io.ktor.server.servlet

import com.newrelic.api.agent.NewRelic
import com.newrelic.api.agent.Trace
import com.newrelic.api.agent.weaver.MatchType
import com.newrelic.api.agent.weaver.Weave
import com.newrelic.api.agent.weaver.Weaver
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Weave(originalName = "io.ktor.server.servlet.KtorServlet", type = MatchType.BaseClass)
public abstract class KtorServlet_Instrumentation {

    @Trace
    protected fun service(request: HttpServletRequest, response: HttpServletResponse) {
        Weaver.callOriginal<Any>()
    }

    @Trace
    private fun asyncService(request: HttpServletRequest, response: HttpServletResponse) {
        NewRelic.getAgent().tracedMethod.setMetricName("Custom","KtorServlet","asyncService")
        Weaver.callOriginal<Any>()
    }

    @Trace
    private fun blockingService(request: HttpServletRequest, response: HttpServletResponse) {
        NewRelic.getAgent().tracedMethod.setMetricName("Custom","KtorServlet","blockingService")
        Weaver.callOriginal<Any>()
    }
}