package io.ktor.routing

import com.newrelic.api.agent.weaver.Weave
import com.newrelic.api.agent.weaver.Weaver
import com.newrelic.instrumentation.labs.ktor.server.KtorServerUtils

@Weave(originalName = "io.ktor.routing.Route")
open class Route_Instrumentation {

    operator fun invoke(body: Route.() -> Unit) : Unit {
        if (!KtorServerUtils.initialized) {
            KtorServerUtils.init()
        }
        return Weaver.callOriginal()
    }
}