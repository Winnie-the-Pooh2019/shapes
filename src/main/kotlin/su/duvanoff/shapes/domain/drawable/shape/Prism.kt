package su.duvanoff.shapes.domain.drawable.shape

import su.duvanoff.shapes.domain.drawable.figure.Figure
import su.duvanoff.shapes.domain.drawable.primitive.Edge
import su.duvanoff.shapes.exception.ShapeException
import su.duvanoff.shapes.exception.type.ExceptionPriority
import su.duvanoff.shapes.utils.compareTo
import su.duvanoff.shapes.utils.times

class Prism<T : Number, E : Edge<T, *>>(val height: T, val base: Figure<T>) : Shape<T> {

//    val firstHeight: E
//    val secondHeight: E
//    val thirdHeight: E
//    val fourthHeight: E

    val upperBase: Figure<T>

    init {
        if (height <= 0)
            throw ShapeException("Height cannot be negative.", ExceptionPriority.ERROR)

        upperBase = base.addHeight(height)

//        firstHeight = base
    }

    override fun volume(): T = base.square() * height
}