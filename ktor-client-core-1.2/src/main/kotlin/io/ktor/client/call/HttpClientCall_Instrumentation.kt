package io.ktor.client.call

import com.newrelic.api.agent.NewRelic
import com.newrelic.api.agent.Trace
import com.newrelic.api.agent.weaver.Weave
import com.newrelic.api.agent.weaver.Weaver
import io.ktor.client.call.TypeInfo

@Weave(originalName = "io.ktor.client.call.HttpClientCall")
public open class HttpClientCall_Instrumentation {

    @Trace(dispatcher = true)
    public suspend fun receive(info: TypeInfo) : Any {
        NewRelic.getAgent().tracedMethod.setMetricName("Custom","Ktor-Client","HttpClientCall",this.javaClass.name,"receive")
        return Weaver.callOriginal()
    }
}
