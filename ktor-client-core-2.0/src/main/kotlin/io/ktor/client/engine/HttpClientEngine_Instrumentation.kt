package io.ktor.client.engine

import com.newrelic.api.agent.HttpParameters
import com.newrelic.api.agent.NewRelic
import com.newrelic.api.agent.Trace
import com.newrelic.api.agent.weaver.MatchType
import com.newrelic.api.agent.weaver.Weave
import com.newrelic.api.agent.weaver.Weaver
import io.ktor.client.request.HttpRequestData
import io.ktor.client.request.HttpResponseData
import java.net.URI

@Weave(type = MatchType.Interface, originalName = "io.ktor.client.engine.HttpClientEngine")
class HttpClientEngine_Instrumentation {

    @Trace
    public suspend fun execute(data: HttpRequestData): HttpResponseData {
        NewRelic.getAgent().tracedMethod.setMetricName("Custom","Ktor-Client","HttpClientEngine",this.javaClass.name,"execute")
        val url = data.url
        val uri : URI = URI.create(url.toString())
        val proc  = data.method.toString()
        val params : HttpParameters = HttpParameters.library("Ktor-Client").uri(uri).procedure(proc).noInboundHeaders().build()
        NewRelic.getAgent().tracedMethod.reportAsExternal(params)
        return Weaver.callOriginal()
    }

}

@Trace
private suspend fun executeWithinCallContext(requestData: HttpRequestData): HttpResponseData {
    NewRelic.getAgent().tracedMethod.setMetricName("Custom","Ktor-Client","HttpClientEngine","executeWithinCallContext")
    val url = requestData.url
    val uri : URI = URI.create(url.toString())
    val proc  = requestData.method.toString()
    val params : HttpParameters = HttpParameters.library("Ktor-Client").uri(uri).procedure(proc).noInboundHeaders().build()
    NewRelic.getAgent().tracedMethod.reportAsExternal(params)
    return Weaver.callOriginal()
}
