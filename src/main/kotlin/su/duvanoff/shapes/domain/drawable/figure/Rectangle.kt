package su.duvanoff.shapes.domain.drawable.figure

import su.duvanoff.shapes.domain.drawable.primitive.Edge
import su.duvanoff.shapes.domain.drawable.primitive.Edge2d
import su.duvanoff.shapes.domain.drawable.primitive.Edge3d
import su.duvanoff.shapes.domain.drawable.primitive.Vertex2d
import su.duvanoff.shapes.exception.ShapeException
import su.duvanoff.shapes.exception.impl.CastingException
import su.duvanoff.shapes.exception.type.ExceptionPriority
import su.duvanoff.shapes.utils.times

@Suppress("UNCHECKED_CAST")
class Rectangle<T : Number, E : Edge<T, *>>(
    first: E,
    second: E,
    third: E,
    fourth: E
) : Figure<T> {

    val first: E
    val second: E
    val third: E
    val fourth: E

    init {
        if (!(first.greaterThenZero() && second.greaterThenZero() && third.greaterThenZero() && fourth.greaterThenZero())
            || first.length != third.length
            || second.length != fourth.length
        )
            throw ShapeException(
                "Rectangle with sides $first and $second and $third and $fourth doesn't exist",
                ExceptionPriority.ERROR
            )

        this.first = first
        this.second = second
        this.third = third
        this.fourth = fourth
    }

    override fun square(): T = (first.length * second.length)

    override fun addHeight(height: T): Figure<T> = when (first) {
        is Edge2d -> Rectangle(
            first.offsetY(height.toDouble()),
            (second as Edge2d).offsetY(height.toDouble()),
            (third as Edge2d).offsetY(height.toDouble()),
            (fourth as Edge2d).offsetY(height.toDouble())
        ) as Figure<T>

        is Edge3d -> Rectangle(
            first.offsetY(height.toDouble()),
            (second as Edge3d).offsetY(height.toDouble()),
            (third as Edge3d).offsetY(height.toDouble()),
            (fourth as Edge3d).offsetY(height.toDouble())
        ) as Figure<T>

        else -> throw CastingException(priority = ExceptionPriority.ERROR)
    }
}