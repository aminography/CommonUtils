@file:Suppress("unused")

package com.aminography.commonutils

import com.google.common.io.BaseEncoding
import java.security.MessageDigest

/**
 * @author aminography
 */

val String.hashBySha256: String
    get() {
        val messageDigest = MessageDigest.getInstance("SHA-256")
        messageDigest.update(toByteArray())
        val digest = messageDigest.digest()
        return BaseEncoding.base16().lowerCase().encode(digest)
    }