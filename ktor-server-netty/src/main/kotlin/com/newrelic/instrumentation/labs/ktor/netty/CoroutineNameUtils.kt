package com.newrelic.instrumentation.labs.ktor.netty

import kotlinx.coroutines.CoroutineName
import kotlin.coroutines.CoroutineContext

fun CoroutineContext.getCoroutineName(): String? = this[CoroutineName.Key]?.name
