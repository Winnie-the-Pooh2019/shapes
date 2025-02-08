package su.duvanoff.shapes.utils

import kotlin.math.pow

fun Double.round(decimals: Int = 0): Double {
    if (decimals < 0)
        throw IllegalArgumentException("decimals must be >= 0")

    return ((this * 10.0.pow(decimals)).toInt()) / 10.0.pow(decimals)
}