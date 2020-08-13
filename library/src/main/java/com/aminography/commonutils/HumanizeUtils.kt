@file:Suppress("unused")

package com.aminography.commonutils

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.concurrent.TimeUnit
import kotlin.math.log2
import kotlin.math.pow

/**
 * @author aminography
 */

// Also see:
// https://developer.android.com/reference/android/text/format/DateUtils.html#formatElapsedTime(long)
val Long.formatMsAsDuration: String
    get() {
        fun normalize(number: Long): String = String.format("%02d", number)

        val seconds = TimeUnit.MILLISECONDS.toSeconds(this) % 60
        val minutes = TimeUnit.MILLISECONDS.toMinutes(this) % 60
        return when (val hours = TimeUnit.MILLISECONDS.toHours(this)) {
            0L -> "${normalize(minutes)}:${normalize(seconds)}"
            else -> "${normalize(hours)}:${normalize(minutes)}:${normalize(seconds)}"
        }
    }

val Int.formatAsFileSize: String
    get() = toLong().formatAsFileSize

val Long.formatAsFileSize: String
    get() = log2(toDouble()).toInt().div(10).let {
        val precision = when (it) {
            0 -> 0; 1 -> 1; else -> 2
        }
        val prefix = arrayOf("", "K", "M", "G", "T", "P", "E")
        String.format("%.${precision}f ${prefix[it]}B", toDouble() / 2.0.pow(it * 10.0))
    }

val Long.groupDigits: String
    get() = decimalFormat.format(this)

private val decimalFormat = DecimalFormat()
    .apply {
        decimalFormatSymbols = DecimalFormatSymbols().apply { groupingSeparator = ',' }
        groupingSize = 3
    }
