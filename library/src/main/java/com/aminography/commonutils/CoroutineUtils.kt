@file:Suppress("unused")

package com.aminography.commonutils

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import timber.log.Timber
import kotlin.coroutines.CoroutineContext

/**
 * @author aminography
 */

val exceptionHandler = CoroutineExceptionHandler { _, exception ->
    Timber.w(exception, "Coroutine Exception Handler, Caught: ${exception.message}")
}

val IO: CoroutineContext = Dispatchers.IO
val DEFAULT: CoroutineContext = Dispatchers.Default
val MAIN: CoroutineContext = Dispatchers.Main
