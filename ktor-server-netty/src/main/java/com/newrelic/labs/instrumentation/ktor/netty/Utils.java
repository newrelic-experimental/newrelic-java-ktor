package com.newrelic.labs.instrumentation.ktor.netty;

import com.newrelic.instrumentation.labs.ktor.netty.CoroutineNameUtilsKt;
import io.ktor.application.Application;
import io.ktor.http.HttpMethod;
import io.ktor.http.RequestConnectionPoint;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.*;

public class Utils {

	
	public static String getCoroutineName(CoroutineContext context) {
		return CoroutineNameUtilsKt.getCoroutineName(context);
	}
	
	public static String getApplicationName(Application app) {
		if(app != null) {
			CoroutineContext ctx = app.getCoroutineContext();
            return getCoroutineName(ctx);
        }
		return null;
	}
	
	public static String getTransactionName(RequestConnectionPoint point) {
		StringBuffer sb = new StringBuffer();
		String uri = point.getUri();
        if (uri.isEmpty()) {
            sb.append("Root");
        } else {
            sb.append(uri);
        }
        HttpMethod method = point.getMethod();
        String value = method.getValue();
        if(value != null && !value.isEmpty()) {
            sb.append(" - {");
            sb.append(value);
            sb.append("}");
        }
        return sb.toString();
	}

}
