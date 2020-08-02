@file:Suppress("unused")

package com.aminography.commonutils

import java.util.concurrent.TimeUnit

/**
 * @author aminography
 */

fun formatDuration(duration: Long): String {
    fun normalize(number: Int): String = String.format("%02d", number)

    val seconds = (TimeUnit.MILLISECONDS.toSeconds(duration) % 60).toInt()
    val minutes = (TimeUnit.MILLISECONDS.toMinutes(duration) % 60).toInt()
    return when (val hours = (TimeUnit.MILLISECONDS.toHours(duration)).toInt()) {
        0 -> "${normalize(minutes)}:${normalize(seconds)}"
        else -> "${normalize(hours)}:${normalize(minutes)}:${normalize(seconds)}"
    }
}