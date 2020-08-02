@file:Suppress("unused")

package com.aminography.commonutils

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat

/**
 * @author aminography
 */

fun Context.getColorCompat(@ColorRes colorResId: Int): Int =
    ContextCompat.getColor(this, colorResId)

fun Context.getDrawableCompat(@DrawableRes resId: Int): Drawable? =
    ContextCompat.getDrawable(this, resId)