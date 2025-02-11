package su.duvanoff.shapes.domain.drawable.figure

import su.duvanoff.shapes.domain.drawable.primitive.Vertex
import su.duvanoff.shapes.domain.drawable.primitive.Vertex2d
import su.duvanoff.shapes.domain.drawable.primitive.Vertex3d
import su.duvanoff.shapes.exception.ShapeException
import su.duvanoff.shapes.exception.type.ExceptionPriority
import su.duvanoff.shapes.utils.compareTo
import su.duvanoff.shapes.utils.times

@Suppress("UNCHECKED_CAST")
class Circle<T : Number, V : Vertex<T>>(val center: V, radio: T) : Figure<T> {

    val radio: T

    init {
        if (radio <= 0)
            throw ShapeException("Radio cannot be zero or negative.", ExceptionPriority.ERROR)

        this.radio = radio
    }

    override fun square(): T = (Math.PI * this.radio * this.radio) as T

    override fun addHeight(height: T): Figure<T> = when (center) {
        is Vertex2d -> Circle(center.offsetY(height.toDouble()), radio.toDouble()) as Figure<T>
        is Vertex3d -> Circle(center.offsetY(height.toDouble()), radio.toDouble()) as Figure<T>

        else -> throw ShapeException("Cannot cast number", ExceptionPriority.ERROR)
    }
}