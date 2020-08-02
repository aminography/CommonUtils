@file:Suppress("unused")

package com.aminography.commonutils

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Configuration
import android.graphics.Point
import android.os.Build
import android.provider.Settings
import android.telephony.TelephonyManager
import android.view.WindowManager

/**
 * @author aminography
 */

val Context.screenSize: Point
    get() = Point().also {
        (getSystemService(Context.WINDOW_SERVICE) as? WindowManager)?.defaultDisplay?.getSize(it)
    }

val Context.isDisplayPortrait: Boolean
    get() = (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)

val Context.androidId: String
    @SuppressLint("HardwareIds")
    get() = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)

val Context.deviceIMEI: String
    @SuppressLint("MissingPermission", "HardwareIds")
    get() {
        var uniqueIdentifier = ""
        val telephonyManager = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        if (hasPermissions(Manifest.permission.READ_PHONE_STATE)) {
            uniqueIdentifier = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                telephonyManager.imei ?: androidId
            } else {
                @Suppress("DEPRECATION")
                telephonyManager.deviceId ?: androidId
            }
        }
        return uniqueIdentifier
    }