@file:Suppress("unused")

package com.aminography.commonutils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import timber.log.Timber

/**
 * @author aminography
 */

val exceptionHandler = CoroutineExceptionHandler { _, exception ->
    Timber.w(exception, "AudioRecorder Coroutine Exception Handler, Caught: ${exception.message}")
}

val IO: CoroutineDispatcher = Dispatchers.IO
val DEFAULT: CoroutineDispatcher = Dispatchers.Default
val MAIN: CoroutineDispatcher = Dispatchers.Main
