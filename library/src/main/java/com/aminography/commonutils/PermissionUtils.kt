@file:Suppress("unused")

package com.aminography.commonutils

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.annotation.Size
import androidx.core.content.ContextCompat

/**
 * @author aminography
 */

fun Context.hasPermissions(
    @Size(min = 1) vararg permissions: String
): Boolean {
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) return true
    return permissions.all {
        ContextCompat.checkSelfPermission(this, it) == PackageManager.PERMISSION_GRANTED
    }
}