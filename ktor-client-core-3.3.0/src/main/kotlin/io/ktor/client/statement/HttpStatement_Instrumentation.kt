package io.ktor.client.statement

import com.newrelic.api.agent.Trace
import com.newrelic.api.agent.weaver.Weave
import com.newrelic.api.agent.weaver.Weaver

@Weave(originalName = "io.ktor.client.statement.HttpStatement")
public class HttpStatement_Instrumentation
{

    @Trace
    public suspend fun <T> execute(block: suspend (response: HttpResponse) -> T): T {
        return Weaver.callOriginal()
    }

    @Trace
    public suspend fun execute(): HttpResponse {
        return Weaver.callOriginal()
    }
}