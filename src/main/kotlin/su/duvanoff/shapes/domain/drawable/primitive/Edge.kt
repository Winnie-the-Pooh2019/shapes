package su.duvanoff.shapes.domain.drawable.primitive

import su.duvanoff.shapes.utils.compareTo

sealed class Edge<T : Number, V : Vertex<T>>(
    val start: V,
    val end: V,
) {
    abstract val length: T

    fun greaterThenZero(): Boolean {
        return length > 0
    }
}
