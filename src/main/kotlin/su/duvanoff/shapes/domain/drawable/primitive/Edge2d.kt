package su.duvanoff.shapes.domain.drawable.primitive

import kotlin.math.pow
import kotlin.math.sqrt

class Edge2d(start: Vertex2d, end: Vertex2d) : Edge<Double, Vertex2d>(start, end) {

    private val _length: Double = sqrt((end.x - start.x).pow(2) + (end.y - start.y).pow(2))

    override val length: Double
        get() = _length

    fun offsetX(number: Double): Edge2d = Edge2d(start.offsetX(number), end.offsetX(number))

    fun offsetY(number: Double): Edge2d = Edge2d(start.offsetY(number), end.offsetY(number))
}
