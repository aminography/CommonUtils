@file:Suppress("unused")

package com.aminography.commonutils

import java.util.concurrent.TimeUnit

/**
 * @author aminography
 */

val Long.formatDuration: String
    get() {
        fun normalize(number: Long): String = String.format("%02d", number)

        val seconds = TimeUnit.MILLISECONDS.toSeconds(this) % 60
        val minutes = TimeUnit.MILLISECONDS.toMinutes(this) % 60
        return when (val hours = TimeUnit.MILLISECONDS.toHours(this)) {
            0L -> "${normalize(minutes)}:${normalize(seconds)}"
            else -> "${normalize(hours)}:${normalize(minutes)}:${normalize(seconds)}"
        }
    }
