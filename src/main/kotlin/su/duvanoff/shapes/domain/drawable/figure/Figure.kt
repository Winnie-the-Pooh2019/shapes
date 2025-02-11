package su.duvanoff.shapes.domain.drawable.figure

interface Figure<T : Number> {
    fun square(): T

    fun addHeight(height: T): Figure<T>
}