package io.ktor.http.content;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.ktor.server.KtorServerUtils;
import io.ktor.routing.Route;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import java.io.File;

@Weave(originalName = "io.ktor.http.content.StaticContentKt")
public class StaticContentKt_Instrumentation {

    @Trace
    public static File getStaticRootFolder(Route route) {
        if(!KtorServerUtils.initialized) {
            KtorServerUtils.init();
        }
        return Weaver.callOriginal();
    }

    @Trace
    public static void setStaticRootFolder(Route route, File rootFolder) {
        if(!KtorServerUtils.initialized) {
            KtorServerUtils.init();
        }
        Weaver.callOriginal();
    }

    @Trace
    public static void file(Route route, String remotePath, String localPath) {
        if(!KtorServerUtils.initialized) {
            KtorServerUtils.init();
        }
        Weaver.callOriginal();
    }

    @Trace
    public static void file(Route route, String remotePath, File localPath) {
        if(!KtorServerUtils.initialized) {
            KtorServerUtils.init();
        }
        Weaver.callOriginal();
    }

    @Trace
    public static void files(Route route, String localPath) {
        if(!KtorServerUtils.initialized) {
            KtorServerUtils.init();
        }
        Weaver.callOriginal();
    }

    @Trace
    public static void files(Route route, File localPath) {
        if(!KtorServerUtils.initialized) {
            KtorServerUtils.init();
        }
        Weaver.callOriginal();
    }

    @Trace
    public static String getStaticBasePackage(Route route) {
        if(!KtorServerUtils.initialized) {
            KtorServerUtils.init();
        }
        return Weaver.callOriginal();
    }

    @Trace
    public static void resource(Route route, String remotePath, String resource, String resourcePackage) {
        if(!KtorServerUtils.initialized) {
            KtorServerUtils.init();
        }
        Weaver.callOriginal();
    }

    @Trace
    public static void resources(Route route, String resourcePackage) {
        if(!KtorServerUtils.initialized) {
            KtorServerUtils.init();
        }
        Weaver.callOriginal();
    }

    @Trace
    public static void defaultResource(Route route, String resource, String resourcePackage) {
        if(!KtorServerUtils.initialized) {
            KtorServerUtils.init();
        }
        Weaver.callOriginal();
    }
}
