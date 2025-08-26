package io.ktor.request;

import com.newrelic.api.agent.weaver.SkipIfPresent;

@SkipIfPresent(originalName = "io.ktor.request.DoubleReceivePreventionToken")
public class DoubleReceivePreventionToken_Instrumentation {
}
