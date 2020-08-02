@file:Suppress("unused")

package com.aminography.commonutils

/**
 * @author aminography
 */

val String.withPersianDigits: String
    get() = StringBuilder().also {
        for (c in toCharArray()) {
            if (Character.isDigit(c))
                it.append(PERSIAN_DIGITS["$c".toInt()])
            else it.append(c)
        }
    }.toString()

val Number.withPersianDigits: String
    get() = StringBuilder().also {
        for (c in "$this".toCharArray()) {
            if (Character.isDigit(c))
                it.append(PERSIAN_DIGITS["$c".toInt()])
            else it.append(c)
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