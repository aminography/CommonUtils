@file:Suppress("unused")

package com.aminography.commonutils

import com.google.android.gms.maps.model.LatLng
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

/**
 * @author aminography
 */

fun LatLng.distanceTo(other: LatLng): Double {
    fun degreesToRadians(degrees: Double): Double = degrees * Math.PI / 180.0

    val earthRadiusKm = 6371

    val dLat = degreesToRadians(other.latitude - latitude)
    val dLon = degreesToRadians(other.longitude - longitude)

    val lat1 = degreesToRadians(latitude)
    val lat2 = degreesToRadians(other.latitude)

    val a =
        sin(dLat / 2) * sin(dLat / 2) + sin(dLon / 2) * sin(dLon / 2) * cos(lat1) * cos(lat2)
    val c = 2 * atan2(sqrt(a), sqrt(1 - a))
    return earthRadiusKm * c
}