@file:Suppress("UNCHECKED_CAST")

package su.duvanoff.shapes.utils

import su.duvanoff.shapes.exception.ShapeException
import su.duvanoff.shapes.exception.type.ExceptionPriority

operator fun <T : Number> T.plus(second: T): T = when (second) {
    is Int -> this.toInt() + second
    is Float -> this.toFloat() + second
    is Double -> this.toDouble() + second
    is Short -> this.toShort() + second
    is Byte -> this.toInt() + second
    is Long -> this.toLong() + second

    else -> throw ShapeException("Cannot cast number", ExceptionPriority.ERROR)
} as T

operator fun <T : Number> T.compareTo(second: T): Int = when (second) {
    is Int -> this.toInt().compareTo(second)
    is Float -> this.toFloat().compareTo(second)
    is Double -> this.toDouble().compareTo(second)
    is Short -> this.toShort().compareTo(second)
    is Byte -> this.toInt().compareTo(second)
    is Long -> this.toLong().compareTo(second)

    else -> throw ShapeException("Cannot cast number", ExceptionPriority.ERROR)
}

operator fun <T : Number> T.minus(second: T): T = when(second) {
    is Int -> this.toInt() - second
    is Float -> this.toFloat() - second
    is Double -> this.toDouble() - second
    is Short -> this.toShort() - second
    is Byte -> this.toInt() - second
    is Long -> this.toLong() - second

    else -> throw ShapeException("Cannot cast number", ExceptionPriority.ERROR)
} as T

operator fun <T : Number> T.times(second: T): T = when(second) {
    is Int -> this.toInt() * second
    is Float -> this.toFloat() * second
    is Double -> this.toDouble() * second
    is Short -> this.toShort() * second
    is Byte -> this.toInt() * second
    is Long -> this.toLong() * second

    else -> throw ShapeException("Cannot cast number", ExceptionPriority.ERROR)
} as T