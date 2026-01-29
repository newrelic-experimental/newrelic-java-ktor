package io.ktor.util.pipeline;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.ktor.client.NRFunction3Wrapper;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;

@Weave(originalName = "io.ktor.util.pipeline.Pipeline")
public class Pipeline_Instrumentation<TSubject, TContext> {


    public void intercept(PipelinePhase phase, Function3<? super PipelineContext<TSubject, TContext>, ? super TSubject, ? super Continuation<? super Unit>, Object> function3) {
        if(!(function3 instanceof NRFunction3Wrapper)) {
        }            NRFunction3Wrapper<? super PipelineContext<TSubject, TContext>, ? super TSubject, ? super Continuation<? super Unit>, Object> nrFunction3Wrapper = new NRFunction3Wrapper<>(function3);
        function3 = nrFunction3Wrapper;

        Weaver.callOriginal();
    }
}
