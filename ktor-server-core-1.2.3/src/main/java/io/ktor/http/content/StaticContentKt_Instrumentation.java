package io.ktor.http.content;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import java.io.File;

@Weave(originalName = "io.ktor.http.content.StaticContentKt")
public class StaticContentKt_Instrumentation {

    @Trace
    public static File getStaticRootFolder(Route route) {
        return Weaver.callOriginal();
    }

    @Trace
    public static void setStaticRootFolder(Route route, File rootFolder) {
        Weaver.callOriginal();
    }

    @Trace
    public static void file(Route route, String remotePath, String localPath) {
        Weaver.callOriginal();
    }

    @Trace
    public static void file(Route route, String remotePath, File localPath) {
        Weaver.callOriginal();
    }

    @Trace
    public static void files(Route route, String localPath) {
        Weaver.callOriginal();
    }

    @Trace
    public static void files(Route route, File localPath) {
        Weaver.callOriginal();
    }

    @Trace
    public static String getStaticBasePackage(Route route) {
        return Weaver.callOriginal();
    }

    @Trace
    public static void resource(Route route, String remotePath, String resource, String resourcePackage) {
        Weaver.callOriginal();
    }

    @Trace
    public static void resources(Route route, String resourcePackage) {
        Weaver.callOriginal();
    }

    @Trace
    public static void defaultResource(Route route, String resource, String resourcePackage) {
        Weaver.callOriginal();
    }
}
