@file:Suppress("unused")

package com.aminography.commonutils

import android.content.Context
import android.graphics.Point
import android.view.WindowManager

/**
 * @author aminography
 */

fun Context.dp2px(dp: Float): Float = dp * resources.displayMetrics.density

fun Context.px2dp(px: Float): Float = px / resources.displayMetrics.density

val Context.screenSize: Point
    get() = Point().also {
        (getSystemService(Context.WINDOW_SERVICE) as? WindowManager)?.defaultDisplay?.getSize(it)
    }
