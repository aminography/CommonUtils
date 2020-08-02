@file:Suppress("unused")

package com.aminography.commonutils

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.graphics.drawable.StateListDrawable
import android.net.Uri
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions

/**
 * @author aminography
 */

fun ImageView.loadImage(
    url: String?,
    @DrawableRes placeholderResId: Int? = null,
    circleCrop: Boolean = false,
    listener: RequestListener<Drawable>? = null
) = Glide.with(context).load(url).also { builder ->
    placeholderResId?.let { builder.apply(RequestOptions.placeholderOf(it)) }
    listener?.let { builder.listener(listener) }
    circleCrop.takeIf { it }?.let { builder.apply(RequestOptions.circleCropTransform()) }
}.into(this)

fun ImageView.loadImage(
    uri: Uri?,
    @DrawableRes placeholderResId: Int? = null,
    circleCrop: Boolean = false,
    listener: RequestListener<Drawable>? = null
) = Glide.with(context).load(uri).also { builder ->
    placeholderResId?.let { builder.apply(RequestOptions.placeholderOf(it)) }
    listener?.let { builder.listener(listener) }
    circleCrop.takeIf { it }?.let { builder.apply(RequestOptions.circleCropTransform()) }
}.into(this)

fun ImageView.loadImage(
    @DrawableRes drawableResId: Int,
    @DrawableRes placeholderResId: Int? = null,
    circleCrop: Boolean = false,
    listener: RequestListener<Drawable>? = null
) = Glide.with(context).load(drawableResId).also { builder ->
    placeholderResId?.let { builder.apply(RequestOptions.placeholderOf(it)) }
    listener?.let { builder.listener(listener) }
    circleCrop.takeIf { it }?.let { builder.apply(RequestOptions.circleCropTransform()) }
}.into(this)

fun ImageView.loadImage(
    image: Bitmap,
    @DrawableRes placeholderResId: Int? = null,
    circleCrop: Boolean = false,
    listener: RequestListener<Drawable>? = null
) = Glide.with(context).load(image).also { builder ->
    placeholderResId?.let { builder.apply(RequestOptions.placeholderOf(it)) }
    listener?.let { builder.listener(listener) }
    circleCrop.takeIf { it }?.let { builder.apply(RequestOptions.circleCropTransform()) }
}.into(this)

fun ImageView.loadImage(
    image: Drawable,
    @DrawableRes placeholderResId: Int? = null,
    circleCrop: Boolean = false,
    listener: RequestListener<Drawable>? = null
) = Glide.with(context).load(image).also { builder ->
    placeholderResId?.let { builder.apply(RequestOptions.placeholderOf(it)) }
    listener?.let { builder.listener(listener) }
    circleCrop.takeIf { it }?.let { builder.apply(RequestOptions.circleCropTransform()) }
}.into(this)

fun ImageView.setStateListSelector(
    @DrawableRes normalResId: Int,
    @DrawableRes disabledResId: Int,
    @DrawableRes pressedResId: Int
) {
    val stateList = StateListDrawable()
    VectorDrawableCompat.create(
        context.resources,
        pressedResId,
        context.theme
    ).let { stateList.addState(intArrayOf(android.R.attr.state_pressed), it) }
    VectorDrawableCompat.create(
        context.resources,
        disabledResId,
        context.theme
    ).let { stateList.addState(intArrayOf(-android.R.attr.state_enabled), it) }
    VectorDrawableCompat.create(
        context.resources,
        normalResId,
        context.theme
    ).let { stateList.addState(intArrayOf(), it) }
    setImageDrawable(stateList)
}
