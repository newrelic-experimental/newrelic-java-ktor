package io.ktor.client.features

import com.newrelic.api.agent.NewRelic
import com.newrelic.api.agent.Trace
import com.newrelic.api.agent.weaver.MatchType
import com.newrelic.api.agent.weaver.Weave
import com.newrelic.api.agent.weaver.Weaver
import io.ktor.client.call.HttpClientCall
import io.ktor.client.request.HttpRequestBuilder

@Weave(type = MatchType.Interface, originalName = "io.ktor.client.features.Sender")
class Sender_Instrumentation {

    @Trace(dispatcher = true)
    public suspend fun execute(requestBuilder: HttpRequestBuilder): HttpClientCall {
        NewRelic.getAgent().tracedMethod.setMetricName("Custom","Ktor-Client","Sender",this.javaClass.name,"execute")
        return Weaver.callOriginal()
    }
}