package su.duvanoff.shapes.domain.drawable.figure

import su.duvanoff.shapes.domain.drawable.primitive.Edge
import su.duvanoff.shapes.domain.drawable.primitive.Edge2d
import su.duvanoff.shapes.domain.drawable.primitive.Edge3d
import su.duvanoff.shapes.utils.compareTo
import su.duvanoff.shapes.utils.plus
import su.duvanoff.shapes.exception.ShapeException
import su.duvanoff.shapes.exception.impl.CastingException
import su.duvanoff.shapes.exception.type.ExceptionPriority
import su.duvanoff.shapes.utils.*
import kotlin.math.sqrt

@Suppress("UNCHECKED_CAST")
class Triangle<T : Number, E : Edge<T, *>>(
    first: E,
    second: E,
    third: E
) : Figure<T> {
    val first: E
    val second: E
    val third: E

    init {
        if (!exists(first, second, third))
            throw ShapeException("Triangle does not exist: $first, $second, $third", ExceptionPriority.ERROR)

        this.first = first
        this.second = second
        this.third = third
    }

    companion object {
        private fun <E : Edge<*, *>> exists(first: E, second: E, third: E): Boolean =
            first.length + second.length > third.length
                    && first.length + third.length > second.length
                    && second.length + third.length > first.length
                    && first.greaterThenZero() && second.greaterThenZero() && third.greaterThenZero()
    }

    override fun square(): T {
        val p = (first.length + second.length + third.length).toDouble()
        
        return sqrt((p * (p - first.length) * (p - second.length) * (p - third.length)).toDouble()) as T
    }

    override fun addHeight(height: T): Figure<T> = when (first) {
        is Edge2d -> Triangle(
            first.offsetY(height.toDouble()),
            (second as Edge2d).offsetY(height.toDouble()),
            (third as Edge2d).offsetY(height.toDouble()),
        ) as Figure<T>

        is Edge3d -> Triangle(
            first.offsetY(height.toDouble()),
            (second as Edge3d).offsetY(height.toDouble()),
            (third as Edge3d).offsetY(height.toDouble()),
        ) as Figure<T>

        else -> throw CastingException(priority = ExceptionPriority.ERROR)
    }
}