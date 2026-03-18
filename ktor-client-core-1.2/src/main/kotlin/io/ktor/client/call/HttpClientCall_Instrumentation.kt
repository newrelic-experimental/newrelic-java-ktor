package io.ktor.client.call

import com.newrelic.api.agent.NewRelic
import com.newrelic.api.agent.Trace
import com.newrelic.api.agent.weaver.Weave
import com.newrelic.api.agent.weaver.Weaver
import com.newrelic.instrumentation.labs.ktor.client_1X.InstrumentationUtils

@Weave(originalName = "io.ktor.client.call.HttpClientCall")
public open class HttpClientCall_Instrumentation {

    @Trace(dispatcher = true)
    public suspend fun receive(info: TypeInfo) : Any {
        if(!InstrumentationUtils.initialized) {
            InstrumentationUtils.init()
        }
        NewRelic.getAgent().tracedMethod.setMetricName("Custom","Ktor-Client","HttpClientCall",this.javaClass.name,"receive")
        return Weaver.callOriginal()
    }
}
