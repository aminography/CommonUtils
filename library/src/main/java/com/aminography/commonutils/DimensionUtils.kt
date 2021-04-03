@file:Suppress("unused")

package com.aminography.commonutils

import android.content.Context
import android.content.res.Resources
import android.graphics.Rect
import android.graphics.RectF
import android.os.Build
import android.util.DisplayMetrics
import android.view.WindowManager
import kotlin.math.roundToInt

/**
 * @author aminography
 */

private val displayMetrics: DisplayMetrics by lazy { Resources.getSystem().displayMetrics }

/**
 * Returns boundary of the screen in pixels (px).
 */
val screenRectPx: Rect
    get() = displayMetrics.run { Rect(0, 0, widthPixels, heightPixels) }

/**
 * Returns boundary of the screen in density independent pixels (dp).
 */
val screenRectDp: RectF
    get() = screenRectPx.run { RectF(0f, 0f, right.px2dp, bottom.px2dp) }

/**
 * Returns boundary of the physical screen including system decor elements (if any) like navigation
 * bar in pixels (px).
 */
val Context.physicalScreenRectPx: Rect
    get() = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
        (getSystemService(Context.WINDOW_SERVICE) as WindowManager)
            .run { DisplayMetrics().also { defaultDisplay.getRealMetrics(it) } }
            .run { Rect(0, 0, widthPixels, heightPixels) }
    } else screenRectPx

/**
 * Returns boundary of the physical screen including system decor elements (if any) like navigation
 * bar in density independent pixels (dp).
 */
val Context.physicalScreenRectDp: RectF
    get() = physicalScreenRectPx.run { RectF(0f, 0f, right.px2dp, bottom.px2dp) }

/**
 * Converts any given number into density independent pixels (dp).
 */
val Number.px2dp: Float
    get() = this.toFloat() / displayMetrics.density

/**
 * Converts any given number into pixels (px).
 */
val Number.dp2px: Int
    get() = (this.toFloat() * displayMetrics.density).roundToInt()