@file:Suppress("unused")

package com.aminography.commonutils

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.provider.Settings
import android.telephony.TelephonyManager

/**
 * @author aminography
 */

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