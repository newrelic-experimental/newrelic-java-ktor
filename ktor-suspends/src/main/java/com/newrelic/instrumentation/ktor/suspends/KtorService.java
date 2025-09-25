package com.newrelic.instrumentation.ktor.suspends;

import com.newrelic.agent.service.AbstractService;
import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.NewRelicApiImplementation;

import java.util.logging.Level;

public class KtorService  extends AbstractService {

    private static final String IGNORE_SUSPENDS_PROPERTY = "newrelic.config.coroutines.suspends.ignoreRegex";
    private static final String IGNORE_KTOR_REGEX = "io\\.ktor\\..*";

    public KtorService() {
        super("KtorService");
    }

    @Override
    protected void doStart() throws Exception {
        String current = System.getProperty(IGNORE_SUSPENDS_PROPERTY);
        String updated = null;
        if(current != null && !current.isEmpty()) {
            updated = current + "," + IGNORE_KTOR_REGEX;
        } else {
            updated = IGNORE_KTOR_REGEX;
        }

        System.setProperty(IGNORE_SUSPENDS_PROPERTY, updated);
        NewRelic.getAgent().getLogger().log(Level.INFO,"Added Ktor classes to Suspends Ignore, value is now {0}", updated);

    }

    @Override
    protected void doStop() throws Exception {

    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
