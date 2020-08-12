@file:Suppress("unused")

package com.aminography.commonutils

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*
import java.util.concurrent.TimeUnit

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
    get() = when {
        this < KB -> String.format(Locale.getDefault(), "%d B", this)
        this < MB -> String.format(Locale.getDefault(), "%.1f KB", toDouble() / KB)
        this < GB -> String.format(Locale.getDefault(), "%.1f MB", toDouble() / MB)
        this < TB -> String.format(Locale.getDefault(), "%.2f GB", toDouble() / GB)
        this < PB -> String.format(Locale.getDefault(), "%.2f TB", toDouble() / TB)
        this < EB -> String.format(Locale.getDefault(), "%.2f PB", toDouble() / PB)
        else -> String.format(Locale.getDefault(), "%.2f EB", toDouble() / EB)
    }

private const val B = 1L
private const val KB = B * 1024
private const val MB = KB * 1024
private const val GB = MB * 1024
private const val TB = GB * 1024
private const val PB = TB * 1024
private const val EB = PB * 1024

val Long.groupDigits: String
    get() = decimalFormat.format(this)

private val decimalFormat = DecimalFormat()
    .apply {
        decimalFormatSymbols = DecimalFormatSymbols().apply { groupingSeparator = ',' }
        groupingSize = 3
    }
