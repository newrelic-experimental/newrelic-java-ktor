package io.ktor.server.routing

import com.newrelic.api.agent.weaver.Weave
import com.newrelic.api.agent.weaver.Weaver

@Weave(originalName = "io.ktor.server.routing.Route")
open class Route_Instrumentation {

    operator fun invoke(body: Route.() -> Unit) : Unit {
        return Weaver.callOriginal()
    }
}