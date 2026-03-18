package io.ktor.util.pipeline

import com.newrelic.api.agent.NewRelic
import com.newrelic.api.agent.Trace
import com.newrelic.api.agent.weaver.MatchType
import com.newrelic.api.agent.weaver.Weave
import com.newrelic.api.agent.weaver.Weaver
import com.newrelic.instrumentation.labs.ktor.utils.PipelineUtils

@Weave(originalName = "io.ktor.util.pipeline.PipelineExecutor", type = MatchType.Interface)
class PipelineExecutor_Instrumentation<R> {

    @Trace
    suspend fun execute(initial: R): R {
        if(!PipelineUtils.initialized) {
            PipelineUtils.init()
        }
        NewRelic.getAgent().tracedMethod.setMetricName("Custom","Ktor","Utils","PipelineExecutor",this.javaClass.simpleName,"execute")
        return Weaver.callOriginal()
    }
}