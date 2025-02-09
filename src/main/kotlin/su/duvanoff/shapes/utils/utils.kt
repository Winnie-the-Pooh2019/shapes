package su.duvanoff.shapes.utils

import kotlin.math.pow

fun Double.round(decimals: Int = 0): Double {
    if (decimals < 0)
        throw IllegalArgumentException("decimals must be >= 0")

    return ((this * 10.0.pow(decimals)).toInt()) / 10.0.pow(decimals)
}

fun String.isFloating(): Boolean {
    val pattern = "(0|0\\.[0-9]*)|([1-9][0-9]*\\.?[0-9]*)|"

    return pattern.toRegex().matches(this)
}