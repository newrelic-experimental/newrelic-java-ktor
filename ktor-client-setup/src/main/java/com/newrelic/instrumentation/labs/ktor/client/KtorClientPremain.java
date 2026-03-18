package com.newrelic.instrumentation.labs.ktor.client;

import com.newrelic.agent.kotlincoroutines.KotlinCoroutinesService;
import com.newrelic.agent.service.ServiceFactory;
import com.newrelic.api.agent.NewRelic;

import java.lang.instrument.Instrumentation;
import java.util.concurrent.*;
import java.util.logging.Level;

public class KtorClientPremain {

    public static void premain(String agentArgs, Instrumentation inst) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        CompletableFuture<Void> future = new CompletableFuture<>();
        executor.submit(new Setup(future));
        try {
            future.get();
        } catch (Exception e) {
            NewRelic.getAgent().getLogger().log(Level.FINER, e, "KtorClientPremain failed");
        }
        executor.shutdown();
    }

    private static class Setup implements Runnable {

        private CompletableFuture<Void> future;

        public Setup(CompletableFuture<Void> future) {
            this.future = future;
        }

        @Override
        public void run() {
            boolean initialized = false;

            while (!initialized) {

                KotlinCoroutinesService kotlinCoroutinesService = ServiceFactory.getKotlinCoroutinesService();
                if(kotlinCoroutinesService != null) {
                    String pattern = "io\\.ktor.\\.client\\..*";
                    kotlinCoroutinesService.addIgnoredRegexDispatched(pattern);
                    kotlinCoroutinesService.addIgnoredRegexSuspends(pattern);
                    kotlinCoroutinesService.addIgnoredRegexScope(pattern);
                    kotlinCoroutinesService.addIgnoredRegExContinuation(pattern);
                    NewRelic.getAgent().getLogger().log(Level.INFO, "KtorClientPremain has been initialized using pattern: {0}", pattern);
                    initialized = true;
                } else {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ignored) {}
                }
                future.complete(null);
            }
        }
    }
}
