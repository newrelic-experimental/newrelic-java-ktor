package com.newrelic.instrumentation.ktor.client;

import com.newrelic.agent.bridge.AgentBridge;
import com.newrelic.api.agent.HttpParameters;
import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TracedMethod;

import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpSendPipeline;
import io.ktor.http.HeadersBuilder;
import io.ktor.util.pipeline.Pipeline;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.pipeline.PipelinePhase;
import kotlin.jvm.functions.Function3;

public class NRInterceptorWrapper<A,B,C,D> implements Function3<A,B,C,D> {

	private Function3<A,B,C,D> delegate = null;
	private PipelinePhase phase = null;
	private Pipeline<?,?> pipeline = null;
	private static boolean isTransformed = false;

	public NRInterceptorWrapper( Function3<A, B, C,D> d, Pipeline<?,?> pLine, PipelinePhase p) {
		delegate = d;
		pipeline = pLine;
		phase = p;
		if(!isTransformed) {
			AgentBridge.instrumentation.retransformUninstrumentedClass(getClass());
			isTransformed = true;
		}
	}

	@Override
	@Trace(dispatcher = true)
	public D invoke(A arg0, B arg1, C arg2) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		String pipelineName = pipeline.getClass().getSimpleName();
		if(pipelineName == null || pipelineName.isEmpty()) {
			pipelineName = "UnknownPipeline";
		}
		if(phase != null) {
			String phaseName = phase.getName();
			if(phaseName == null || phaseName.isEmpty()) phaseName = "UnknownPhase";
			traced.setMetricName("Custom","Ktor","PipelinePhase",pipelineName, phaseName,"invoke");
			if(pipeline instanceof HttpSendPipeline) {
				if(phaseName.equals("Engine")) {
					if(arg0 instanceof PipelineContext) {
						PipelineContext<?,?> ctx = (PipelineContext<?, ?>)arg0;
						
						Object pipelineContextObject = ctx.getContext();
						if(pipelineContextObject instanceof HttpRequestBuilder) {
							HttpRequestBuilder builder = (HttpRequestBuilder)pipelineContextObject;
							HttpParameters params = InstrumentationUtils.getParams(builder);
							if(params != null) {
								ctx.params = params;
							}
							HeadersBuilder headersBuilder = builder.getHeaders();
							KtorHeaders headers = new KtorHeaders(headersBuilder);
							NewRelic.getAgent().getTransaction().insertDistributedTraceHeaders(headers);
						}
						ctx.httpCallSegment = NewRelic.getAgent().getTransaction().startSegment("KtorHttpClientCall");
					}
				} else if(phaseName.equals("Receive")) {
					if(arg0 instanceof PipelineContext) {
						PipelineContext<?,?> ctx = (PipelineContext<?, ?>)arg0;
						if(ctx.httpCallSegment != null) {
							if(ctx.params != null) {
								ctx.httpCallSegment.reportAsExternal(ctx.params);
							}
							ctx.httpCallSegment.end();
							ctx.httpCallSegment = null;
						}
					}
				}
			}
		} else {
			traced.setMetricName("Custom","Ktor","PipelinePhase",pipelineName, "UnknownPhase","invoke");
		}
		return delegate.invoke(arg0, arg1, arg2);
	}

}
