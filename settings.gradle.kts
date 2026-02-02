rootProject.name = "ktor-instrumentation"

// Client instrumentation modules
include("ktor-client-core-1.2")
include("ktor-client-core-2.0")
include("ktor-client-jetty-2.0")
include("ktor-client-jetty-jakarta-3.0")
include("ktor-client-cio")

// Server instrumentation modules
include("ktor-server-core-1.1")
include("ktor-server-core-1.2.3")
include("ktor-server-core-2.0.0")
include("ktor-server-core-3.0.0")
include("ktor-server-netty")
include("ktor-server-netty-2.0")
include("ktor-server-netty-3.0")
include("ktor-server-servlet")
include("ktor-server-servlet-jakarta")
include("ktor-server-cio-2.0.0")
include("ktor-server-jetty")
include("ktor-server-jetty-jakarta")
include("ktor-server-jetty-jakarta-3.1")
include("ktor-server-jetty-jakarta-3.3")

// Utility modules
include("ktor-utils-1.4")
include("ktor-utils-2.0")
