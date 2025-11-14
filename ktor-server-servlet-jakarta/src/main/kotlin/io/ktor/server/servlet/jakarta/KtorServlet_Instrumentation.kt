package io.ktor.server.servlet.jakarta

import com.newrelic.api.agent.NewRelic
import com.newrelic.api.agent.Trace
import com.newrelic.api.agent.weaver.MatchType
import com.newrelic.api.agent.weaver.Weave
import com.newrelic.api.agent.weaver.Weaver
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@Weave(originalName = "io.ktor.server.servlet.jakarta.KtorServlet", type = MatchType.BaseClass)
public abstract class KtorServlet_Instrumentation {

    @Trace
    private fun asyncService(request: HttpServletRequest, response: HttpServletResponse) {
        NewRelic.getAgent().tracedMethod.setMetricName("Custom","KtorServlet","asyncService")
        Weaver.callOriginal<Any>()
    }

    @Trace
    private fun blockingService(request: HttpServletRequest, response: HttpServletResponse) {
        NewRelic.getAgent().tracedMethod.setMetricName("Custom","KtorServlet","asyncService")

        Weaver.callOriginal<Any>()
    }

}