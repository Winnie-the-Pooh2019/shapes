package su.duvanoff.shapes.domain.drawable.primitive

sealed interface Vertex<T : Number> {
    fun to(other: Vertex<T>): Edge<T, *>
}