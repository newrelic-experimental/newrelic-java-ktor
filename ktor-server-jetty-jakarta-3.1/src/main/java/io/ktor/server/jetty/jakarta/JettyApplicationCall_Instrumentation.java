package io.ktor.server.jetty.jakarta;

import com.newrelic.api.agent.Token;
import com.newrelic.api.agent.weaver.NewField;
import com.newrelic.api.agent.weaver.Weave;
import io.ktor.server.application.Application;
import kotlin.time.Duration;
import org.eclipse.jetty.server.Request;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kotlin.coroutines.CoroutineContext;

@Weave(originalName = "io.ktor.server.jetty.jakarta.JettyApplicationCall")
public class JettyApplicationCall_Instrumentation {

    
    private JettyApplicationCall_Instrumentation(Application application, Request request, HttpServletRequest servletRequest, HttpServletResponse servletResponse, CoroutineContext engineContext, CoroutineContext userContext, CoroutineContext coroutineContext , long idleTimeout) {
        
    }
}