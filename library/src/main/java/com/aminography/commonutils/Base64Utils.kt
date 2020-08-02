@file:Suppress("unused")

package com.aminography.commonutils

import android.util.Base64

/**
 * @author aminography
 */

fun ByteArray.encodeBase64(): String =
    Base64.encode(this, Base64.NO_WRAP).toString(charset("UTF-8"))

fun String.decodeBase64(): ByteArray =
    Base64.decode(this, Base64.NO_WRAP)