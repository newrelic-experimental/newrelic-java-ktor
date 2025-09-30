package io.ktor.routing;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.TransactionNamePriority;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.instrumentation.labs.ktor.server.KtorExtendedRequest;

import java.util.logging.Level;

@Weave(originalName = "io.ktor.routing.RoutingApplicationCall")
public class RoutingApplicationCall_Instrumentation {

    public RoutingApplicationCall_Instrumentation(io.ktor.application.ApplicationCall call, io.ktor.routing.Route route, io.ktor.request.ApplicationReceivePipeline requestPipeline, io.ktor.response.ApplicationSendPipeline sendPipeline, io.ktor.http.Parameters parameters) {
        NewRelic.getAgent().getLogger().log(Level.FINE, "Call to RoutingApplicationCall_Instrumentation.<init>({0}, {1}, {2}, {3}, {4})", call, route, requestPipeline, sendPipeline, parameters);
        KtorExtendedRequest extendedRequest = new KtorExtendedRequest(call);
        NewRelic.getAgent().getTransaction().setWebRequest(extendedRequest);
        NewRelic.getAgent().getTransaction().setTransactionName(TransactionNamePriority.CUSTOM_HIGH, false, "KtorServerRouting", route.toString());
    }
}
