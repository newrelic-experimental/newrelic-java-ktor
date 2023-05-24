package io.ktor.request;

import java.io.InputStream;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TracedMethod;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import io.ktor.application.ApplicationCall;
import io.ktor.http.HttpMethod;
import io.ktor.http.Parameters;
import io.ktor.http.content.MultiPartData;
import kotlin.coroutines.Continuation;
import kotlin.reflect.KClass;
import kotlinx.coroutines.io.ByteReadChannel;

@Weave
public abstract class ApplicationReceiveFunctionsKt {

	@Trace(dispatcher = true)
	public static <T> Object receive(ApplicationCall call, KClass<T> clazz, Continuation<? super T> continuation) {
		ApplicationRequest req = call.getRequest();
		if(req != null) {
			TracedMethod traced = NewRelic.getAgent().getTracedMethod();
			String path = ApplicationRequestPropertiesKt.path(req);
			if(path != null && !path.isEmpty()) {
				traced.addCustomAttribute("Path", path);
			}
			HttpMethod method = ApplicationRequestPropertiesKt.getHttpMethod(req);
			if(method != null) {
				traced.addCustomAttribute("HttpMethod", method.getValue());
			}			
		}
		
		return Weaver.callOriginal();
	}

	@Trace(dispatcher = true)
	public static <T> Object receiveOrNull(ApplicationCall call, KClass<T> clazz, Continuation<? super T> continuation) {
		ApplicationRequest req = call.getRequest();
		if(req != null) {
			TracedMethod traced = NewRelic.getAgent().getTracedMethod();
			String path = ApplicationRequestPropertiesKt.path(req);
			if(path != null && !path.isEmpty()) {
				traced.addCustomAttribute("Path", path);
			}
			HttpMethod method = ApplicationRequestPropertiesKt.getHttpMethod(req);
			if(method != null) {
				traced.addCustomAttribute("HttpMethod", method.getValue());
			}			
		}
		return Weaver.callOriginal();
	}

	@Trace(dispatcher = true)
	public static Object receiveText(ApplicationCall call, Continuation<? super String> continuation) {
		ApplicationRequest req = call.getRequest();
		if(req != null) {
			TracedMethod traced = NewRelic.getAgent().getTracedMethod();
			String path = ApplicationRequestPropertiesKt.path(req);
			if(path != null && !path.isEmpty()) {
				traced.addCustomAttribute("Path", path);
			}
			HttpMethod method = ApplicationRequestPropertiesKt.getHttpMethod(req);
			if(method != null) {
				traced.addCustomAttribute("HttpMethod", method.getValue());
			}			
		}
		return Weaver.callOriginal();
	}

	@Trace(dispatcher = true)
	public static Object receiveChannel(ApplicationCall call, Continuation<? super ByteReadChannel> continuation) {
		ApplicationRequest req = call.getRequest();
		if(req != null) {
			TracedMethod traced = NewRelic.getAgent().getTracedMethod();
			String path = ApplicationRequestPropertiesKt.path(req);
			if(path != null && !path.isEmpty()) {
				traced.addCustomAttribute("Path", path);
			}
			HttpMethod method = ApplicationRequestPropertiesKt.getHttpMethod(req);
			if(method != null) {
				traced.addCustomAttribute("HttpMethod", method.getValue());
			}			
		}
		return Weaver.callOriginal();
	}

	@Trace(dispatcher = true)
	public static Object receiveStream(ApplicationCall call, Continuation<? super InputStream> continuation) {
		ApplicationRequest req = call.getRequest();
		if(req != null) {
			TracedMethod traced = NewRelic.getAgent().getTracedMethod();
			String path = ApplicationRequestPropertiesKt.path(req);
			if(path != null && !path.isEmpty()) {
				traced.addCustomAttribute("Path", path);
			}
			HttpMethod method = ApplicationRequestPropertiesKt.getHttpMethod(req);
			if(method != null) {
				traced.addCustomAttribute("HttpMethod", method.getValue());
			}			
		}
		return Weaver.callOriginal();
	}

	@Trace(dispatcher = true)
	public static Object receiveMultipart(ApplicationCall call, Continuation<? super MultiPartData> continuation) {
		ApplicationRequest req = call.getRequest();
		if(req != null) {
			TracedMethod traced = NewRelic.getAgent().getTracedMethod();
			String path = ApplicationRequestPropertiesKt.path(req);
			if(path != null && !path.isEmpty()) {
				traced.addCustomAttribute("Path", path);
			}
			HttpMethod method = ApplicationRequestPropertiesKt.getHttpMethod(req);
			if(method != null) {
				traced.addCustomAttribute("HttpMethod", method.getValue());
			}			
		}
		return Weaver.callOriginal();
	}

	@Trace(dispatcher = true)
	public static Object receiveParameters(ApplicationCall call, Continuation<? super Parameters> continuation)  {
		ApplicationRequest req = call.getRequest();
		if(req != null) {
			TracedMethod traced = NewRelic.getAgent().getTracedMethod();
			String path = ApplicationRequestPropertiesKt.path(req);
			if(path != null && !path.isEmpty()) {
				traced.addCustomAttribute("Path", path);
			}
			HttpMethod method = ApplicationRequestPropertiesKt.getHttpMethod(req);
			if(method != null) {
				traced.addCustomAttribute("HttpMethod", method.getValue());
			}			
		}
		return Weaver.callOriginal();
	}


}
