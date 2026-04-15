package com.newrelic.instrumentation.labs.ktor.ignores;

import com.newrelic.agent.kotlincoroutines.KotlinCoroutinesService;
import com.newrelic.agent.service.ServiceFactory;
import com.newrelic.api.agent.NewRelic;

import java.lang.instrument.Instrumentation;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Level;

public class KtorSetupPremain {

    private static ExecutorService executor = Executors.newFixedThreadPool(3);

    public static void premain(String agentArgs, Instrumentation inst) {
        NewRelic.getAgent().getLogger().log(Level.INFO, "KtorIgnoresPremain called");
        CompletableFuture<Void> future = new CompletableFuture<>();
        executor.submit(new Setup(future));
        NewRelic.getAgent().getLogger().log(Level.INFO, "Setup submitted to Executor");
    }

    private static void await(CompletableFuture<Void> future) {
        try {
            future.get();
            NewRelic.getAgent().getLogger().log(Level.INFO, "Ktor Ignores has completed successfully");

        } catch (Exception e) {
            NewRelic.getAgent().getLogger().log(Level.FINER, e, "KtorClientPremain failed");
        }
        executor.shutdown();
        NewRelic.getAgent().getLogger().log(Level.INFO, "Ktor Ignores executor has been shut down");
    }

    private static class Setup implements Runnable {

        private CompletableFuture<Void> future;

        public Setup(CompletableFuture<Void> future) {
            this.future = future;
        }

        @Override
        public void run() {
            NewRelic.getAgent().getLogger().log(Level.INFO, "Call to Setup.run");
            boolean initialized = false;
            executor.submit(() -> await(future));;
            while (!initialized) {

                KotlinCoroutinesService kotlinCoroutinesService = ServiceFactory.getKotlinCoroutinesService();
                NewRelic.getAgent().getLogger().log(Level.INFO, "In Setup.run, value of kotlinCoroutinesService = {0}", kotlinCoroutinesService);
                if(kotlinCoroutinesService != null) {
                    String pattern = ".*io\\.ktor.\\..*";
//                    kotlinCoroutinesService.addIgnoredRegexDispatched(pattern);
                    kotlinCoroutinesService.addIgnoredRegexSuspends(pattern);
//                    kotlinCoroutinesService.addIgnoredRegexScope(pattern);
//                    kotlinCoroutinesService.addIgnoredRegExContinuation(pattern);
                    kotlinCoroutinesService.reconfigure();
                    NewRelic.getAgent().getLogger().log(Level.INFO, "KtorIgnoresPremain has been initialized using pattern: {0}", pattern);
                    initialized = true;
                    future.complete(null);
                } else {
                    NewRelic.getAgent().getLogger().log(Level.INFO, "In Setup.run, did not find KotlinCoroutinesService, sleeping for 500 ms");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ignored) {}
                }
            }
        }
    }
}
