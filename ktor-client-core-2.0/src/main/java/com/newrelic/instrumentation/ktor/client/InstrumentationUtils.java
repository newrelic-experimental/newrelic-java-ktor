package com.newrelic.instrumentation.ktor.client;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.newrelic.agent.bridge.AgentBridge;

import io.ktor.client.HttpClient;

public class InstrumentationUtils {
	
	public static boolean HTTPCLIENT_INSTRUMENTED = false;
	public static boolean HTTPSENDER_INSTRUMENTED = false;
	private static InstrumentationUtils INSTANCE = new InstrumentationUtils();
	private static final List<String> httpClient_Methods = new ArrayList<>();
	
	static {
		httpClient_Methods.add("execute$ktor_client_core");
	}
	
	private InstrumentationUtils() {
		
	}
	
	public static void instrumentHttpClient(HttpClient client) {
		synchronized (INSTANCE) {
			if (!HTTPCLIENT_INSTRUMENTED) {
				Class<?> clazz = client.getClass();
				Method[] methods = clazz.getMethods();
				for(Method method : methods) {
					String methodName = method.getName();
					if(httpClient_Methods.contains(methodName)) {
						AgentBridge.instrumentation.instrument(method, "Custom/HttpClient");
						break;
					}
				}
				HTTPCLIENT_INSTRUMENTED = true;
			}
		}
	}
	
	public static void instrumentDefaultSender(Class<?> senderClass) {
		synchronized (INSTANCE) {
			if (!HTTPSENDER_INSTRUMENTED) {
				Method[] methods = senderClass.getMethods();
				for (Method method : methods) {
					String methodName = method.getName();
					if (methodName.equals("execute")) {
						AgentBridge.instrumentation.instrument(method, "Custom/HttpSender");
						break;
					}
				} 
				HTTPSENDER_INSTRUMENTED = true;
			}
			
		}
		
	}

}
