@file:Suppress("DEPRECATION", "unused")

package com.aminography.commonutils

import android.Manifest
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Build
import android.os.PowerManager
import androidx.annotation.RequiresPermission

/**
 * @author aminography
 */

val Context.isNetworkAvailable: Boolean
    @RequiresPermission(Manifest.permission.READ_PHONE_STATE)
    get() = (getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).let {
        val networkInfo = it.activeNetworkInfo ?: return false
        return !isDozing(this) && networkInfo.state == NetworkInfo.State.CONNECTED && networkInfo.isConnected
    }

val Context.networkStatus: NetworkStatus
    @RequiresPermission(Manifest.permission.READ_PHONE_STATE)
    get() {
        if (isDozing(this)) return NetworkStatus.DISCONNECTED
        (getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).let {
            val networkInfo = it.activeNetworkInfo ?: return NetworkStatus.DISCONNECTED
            return if (networkInfo.type == ConnectivityManager.TYPE_WIFI || networkInfo.type == ConnectivityManager.TYPE_ETHERNET) {
                NetworkStatus.UNMETERED
            } else NetworkStatus.METERED
        }
    }

/**
 * Returns true if the device is in Doze/Idle mode. Should be called before checking the network
 * connection because the ConnectionManager may report the device is connected when it isn't during
 * Idle mode.
 */
private fun isDozing(context: Context): Boolean {
    return if (Build.VERSION.SDK_INT >= 23) {
        val powerManager = context.getSystemService(Context.POWER_SERVICE) as PowerManager
        powerManager.isDeviceIdleMode && !powerManager.isIgnoringBatteryOptimizations(context.packageName)
    } else false
}

enum class NetworkStatus {
    DISCONNECTED,
    METERED,
    UNMETERED
}
