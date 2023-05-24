package com.newrelic.labs.instrumentation.ktor.netty;

import io.ktor.application.Application;
import io.ktor.http.HttpMethod;
import io.ktor.http.RequestConnectionPoint;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineName;

public class Utils {

	
	public static String getCoroutineName(CoroutineContext context) {
		CoroutineName cName = context.get(CoroutineName.Key);
		if(cName != null) {
			String name = cName.getName();
			if(name != null && !name.isEmpty()) return name;
		}

		return null;
	}
	
	public static String getApplicationName(Application app) {
		if(app != null) {
			CoroutineContext ctx = app.getCoroutineContext();
			if(ctx != null) {
				return getCoroutineName(ctx);
			}
		}
		return null;
	}
	
	public static String getTransactionName(RequestConnectionPoint point) {
		StringBuffer sb = new StringBuffer();
		String uri = point.getUri();
		if(uri != null) {
			if(uri.isEmpty()) {
				sb.append("Root");
			} else {
				sb.append(uri);
			}
		}
		HttpMethod method = point.getMethod();
		if(method != null) {
			String value = method.getValue();
			if(value != null && !value.isEmpty()) {
				sb.append(" - {");
				sb.append(value);
				sb.append("}");
			}
		}
		return sb.toString();
	}

}
