package com.newrelic.instrumentation.labs.netty.eventloop;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.RunnableScheduledFuture;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Token;

public class Utils {

	private static List<String> ignoredPackages = new ArrayList<String>();
	
	public static final String LAMBDA = "$$Lambda";

	private static List<String> ignoredClasses = new ArrayList<String>();

	private static List<Class<?>> ignoredSuperClasses = new ArrayList<Class<?>>();
	
	private static final String NEWRELICAGENT = "com.newrelic.agent";
	
	@SuppressWarnings("unchecked")
	public static <T> NRRunnable getWrapper(Runnable runnable) {		
		if(runnable == null || runnable instanceof NRRunnable || runnable instanceof FutureTask) return null;
		
		if(isCompletion(runnable)) {
			Token token = NewRelic.getAgent().getTransaction().getToken();
			if(!token.isActive()) {
				token.expire();
				token = null;
				return null;
			}
			if(runnable instanceof Comparable) {
				return new NRComparableRunnable<T>(runnable, token);
			}

			return new NRRunnable(runnable,token);
		}
		
		String fullclassname = runnable.getClass().getName();
		if(ignoredClasses.contains(fullclassname)) return null;
		
		for(Class<?> theClass : ignoredSuperClasses) {
			if(theClass.isInstance(runnable)) return null;
		}
						
		Package runPackage = runnable.getClass().getPackage();
		
		if(runPackage.getName().startsWith(NEWRELICAGENT)) return null;
		
		for(String ignore : ignoredPackages) {
			if(runPackage.getName().startsWith(ignore)) return null;
		}
				
		Token token = NewRelic.getAgent().getTransaction().getToken();
		if(!token.isActive()) {
			token.expire();
			token = null;
			return null;
		}

		if(runnable instanceof RunnableScheduledFuture) {
			return new NRRunnableScheduledFuture<T>((RunnableScheduledFuture<T>) runnable, token);
		}
		
		if(runnable instanceof RunnableFuture) {
			return new NRRunnableFuture<T>((RunnableFuture<T>)runnable, token);
		}

		if(runnable instanceof Comparable) {
			return new NRComparableRunnable<T>(runnable, token);
		}
		return new NRRunnable(runnable,token);
	}
	
	public static boolean isCompletion(Object obj) {
		String classname = obj.getClass().getName();
		
		if(!classname.startsWith("java.util.concurrent.CompletableFuture$")) return false;
		
		if(classname.startsWith("java.util.concurrent.CompletableFuture$Bi")) return true;
		
		if(classname.startsWith("java.util.concurrent.CompletableFuture$Uni")) return true;
		
		if(classname.startsWith("java.util.concurrent.CompletableFuture$Or")) return true;
		
		if(classname.equals("java.util.concurrent.CompletableFuture$AnyOf")) return true;
		
		if(classname.equals("java.util.concurrent.CompletableFuture.CoCompletion")) return true;
				
		if(classname.equals("java.util.concurrent.CompletableFuture.Signaller")) return true;

		return false;
	}

	public static <V> NRCallable<V> getWrapper(Callable<V> callable) {
		if(callable == null || callable instanceof NRCallable) return null;
		
		String fullclassname = callable.getClass().getName();
		if(ignoredClasses.contains(fullclassname)) return null;

		Package runPackage = callable.getClass().getPackage();
		
		if(runPackage.getName().startsWith(NEWRELICAGENT)) return null;
		
		for(String ignore : ignoredPackages) {
			if(runPackage.getName().startsWith(ignore)) return null;
		}
				
		Token token = NewRelic.getAgent().getTransaction().getToken();
		if(!token.isActive()) {
			token.expire();
			token = null;
			return null;
		}
		
		
		return new NRCallable<V>(callable,token);
	}

}
