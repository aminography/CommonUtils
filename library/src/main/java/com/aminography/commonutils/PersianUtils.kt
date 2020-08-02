@file:Suppress("unused")

package com.aminography.commonutils

/**
 * @author aminography
 */

val String.withPersianDigits: String
    get() = StringBuilder().also { builder ->
        toCharArray().forEach {
            builder.append(if (Character.isDigit(it)) PERSIAN_DIGITS["$it".toInt()] else it)
        }
    }.toString()

val Number.withPersianDigits: String
    get() = StringBuilder().also { builder ->
        "$this".toCharArray().forEach {
            builder.append(if (Character.isDigit(it)) PERSIAN_DIGITS["$it".toInt()] else it)
        }
    }.toString()

private val PERSIAN_DIGITS = charArrayOf(
    '0' + 1728,
    '1' + 1728,
    '2' + 1728,
    '3' + 1728,
    '4' + 1728,
    '5' + 1728,
    '6' + 1728,
    '7' + 1728,
    '8' + 1728,
    '9' + 1728
)
