@file:Suppress("unused")

package com.aminography.commonutils

import android.content.res.Resources
import android.graphics.Rect
import android.graphics.RectF

/**
 * @author aminography
 */

val Number.dp2px: Float
    get() = this.toFloat() * Resources.getSystem().displayMetrics.density

val Number.px2dp: Float
    get() = this.toFloat() / Resources.getSystem().displayMetrics.density

val screenSizePx: Rect
    get() = Resources.getSystem().displayMetrics.run {
        Rect(0, 0, widthPixels, heightPixels)
    }

val screenSizeDp: RectF
    get() = Resources.getSystem().displayMetrics.run {
        RectF(0f, 0f, widthPixels / xdpi, heightPixels / ydpi)
    }