package su.duvanoff.shapes.domain.drawable.shape

interface Shape<T : Number> {
    fun volume(): T
}