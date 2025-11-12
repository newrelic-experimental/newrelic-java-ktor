package io.ktor.server.jetty.jakarta;

import com.newrelic.api.agent.weaver.Weave;
import io.ktor.server.application.Application;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Response;
import java.util.concurrent.Executor;
import kotlin.coroutines.CoroutineContext;
import kotlin.time.Duration;

@Weave(originalName = "io.ktor.server.jetty.jakarta.JettyApplicationCall")
public class JettyApplicationCall_Instrumentation {


private JettyApplicationCall_Instrumentation(Application application, Request jettyRequest, Response jettyResponse, Executor executor, CoroutineContext userContext, CoroutineContext coroutineContext, Duration idleTimeout) {

    }
}