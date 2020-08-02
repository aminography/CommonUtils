package com.aminography.commonutils

import android.content.Context
import android.widget.Toast

/**
 * @author aminography
 */

fun Context.toast(message: CharSequence?) =
    message?.let { Toast.makeText(this, it, Toast.LENGTH_SHORT).show() }

fun Context.longToast(message: CharSequence?) =
    message?.let { Toast.makeText(this, it, Toast.LENGTH_LONG).show() }

fun Context.toast(message: Int) =
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

fun Context.longToast(message: Int) =
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()