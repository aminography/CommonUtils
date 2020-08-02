@file:Suppress("unused")

package com.aminography.commonutils

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes

/**
 * @author aminography
 */

private var toast: Toast? = null

fun Context.toast(message: CharSequence?) {
    toast?.cancel()
    toast = message?.let { Toast.makeText(this, it, Toast.LENGTH_SHORT) }?.apply { show() }
}

fun Context.longToast(message: CharSequence?) {
    toast?.cancel()
    toast = message?.let { Toast.makeText(this, it, Toast.LENGTH_LONG) }?.apply { show() }
}

fun Context.toast(@StringRes message: Int) {
    toast?.cancel()
    toast = Toast.makeText(this, message, Toast.LENGTH_SHORT).apply { show() }
}

fun Context.longToast(@StringRes message: Int) {
    toast?.cancel()
    toast = Toast.makeText(this, message, Toast.LENGTH_LONG).apply { show() }
}
