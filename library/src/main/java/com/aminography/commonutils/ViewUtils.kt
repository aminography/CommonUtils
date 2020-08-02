@file:Suppress("unused")

package com.aminography.commonutils

import android.content.Context
import android.graphics.PorterDuff
import android.os.Build
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.DynamicDrawableSpan
import android.text.style.ImageSpan
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.widget.ProgressBar
import android.widget.SeekBar
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.LayoutRes
import androidx.annotation.RequiresApi
import androidx.core.graphics.drawable.DrawableCompat

/**
 * @author aminography
 */

fun View.visible() = if (visibility != View.VISIBLE) visibility = View.VISIBLE else Unit

fun View.invisible() = if (visibility != View.INVISIBLE) visibility = View.INVISIBLE else Unit

fun View.gone() = if (visibility != View.GONE) visibility = View.GONE else Unit

fun LayoutInflater.inflate(@LayoutRes layoutResId: Int): View = inflate(layoutResId, null)

fun ProgressBar.setColor(context: Context, @ColorRes colorResId: Int) =
    DrawableCompat.setTint(this.indeterminateDrawable, context.getColorCompat(colorResId))

@Suppress("DEPRECATION")
@RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
fun SeekBar.setColor(@ColorRes colorResId: Int) {
    progressDrawable.setColorFilter(context.getColorCompat(colorResId), PorterDuff.Mode.SRC_ATOP)
    thumb.setColorFilter(context.getColorCompat(colorResId), PorterDuff.Mode.SRC_ATOP)
}

fun MenuItem.iconifyTitle(context: Context, title: String, @DrawableRes iconResId: Int) {
    SpannableStringBuilder("#  $title ").apply {
        setSpan(
            ImageSpan(context, iconResId, DynamicDrawableSpan.ALIGN_CENTER),
            0,
            1,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
    }.let {
        setTitle(it)
    }
}
