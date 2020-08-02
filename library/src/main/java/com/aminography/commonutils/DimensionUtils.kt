package com.aminography.commonutils

import android.content.Context

/**
 * @author aminography
 */

fun Context.dp2px(dp: Float): Float = dp * resources.displayMetrics.density

fun Context.px2dp(px: Float): Float = px / resources.displayMetrics.density