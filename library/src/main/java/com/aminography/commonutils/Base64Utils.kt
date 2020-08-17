@file:Suppress("unused")

package com.aminography.commonutils

import android.util.Base64

/**
 * @author aminography
 */

val ByteArray.encodeBase64: String
    get() = Base64.encode(this, Base64.NO_WRAP).toString(charset("UTF-8"))

val String.decodeBase64: ByteArray
    get() = Base64.decode(this, Base64.NO_WRAP)