package io.ktor.client.engine

import com.newrelic.api.agent.HttpParameters
import com.newrelic.api.agent.NewRelic
import com.newrelic.api.agent.Trace
import com.newrelic.api.agent.weaver.MatchType
import com.newrelic.api.agent.weaver.Weave
import com.newrelic.api.agent.weaver.Weaver
import io.ktor.client.call.HttpClientCall
import io.ktor.client.request.HttpRequestData
import io.ktor.client.request.HttpResponseData
import java.net.URI

@Weave(originalName = "io.ktor.client.engine.HttpClientEngine", type = MatchType.Interface)
public class HttpClientEngine_Instrumentation {

    @Trace(dispatcher = true)
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