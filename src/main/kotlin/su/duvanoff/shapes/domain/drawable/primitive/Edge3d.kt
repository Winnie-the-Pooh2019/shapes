package su.duvanoff.shapes.domain.drawable.primitive

import kotlin.math.pow
import kotlin.math.sqrt

class Edge3d(start: Vertex3d, end: Vertex3d) : Edge<Double, Vertex3d>(start, end) {

    private val _length: Double = sqrt((end.x - start.x).pow(2) + (end.y - start.y).pow(2) + (end.z - start.z).pow(2))

    override val length: Double
        get() = _length

    fun offsetX(number: Double): Edge3d = Edge3d(start.offsetX(number), end.offsetX(number))

    fun offsetY(number: Double): Edge3d = Edge3d(start.offsetY(number), end.offsetY(number))
}