package io.ktor.client.statement

import com.newrelic.api.agent.Trace
import com.newrelic.api.agent.weaver.Weave
import com.newrelic.api.agent.weaver.Weaver
import com.newrelic.instrumentation.labs.ktor.client.InstrumentationUtils

@Weave(originalName = "io.ktor.client.statement.HttpStatement")
public class HttpStatement_Instrumentation
{

    @Trace
    public suspend fun <T> execute(block: suspend (response: HttpResponse) -> T): T {
        if (!InstrumentationUtils.initialized) {
            InstrumentationUtils.init()
        }
        return Weaver.callOriginal()
    }

    @Trace
    public suspend fun execute(): HttpResponse {
        if (!InstrumentationUtils.initialized) {
            InstrumentationUtils.init()
        }
        return Weaver.callOriginal()
    }
}