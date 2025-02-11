package su.duvanoff.shapes.domain.drawable.primitive

data class Vertex2d(val x: Double, val y: Double) : Vertex<Double> {

    override fun to(other: Vertex<Double>): Edge<Double, *> = when(other) {
        is Vertex2d -> Edge2d(this, other)
        is Vertex3d -> Edge3d(Vertex3d(this.x, this.y, 0.0), other)
    }

    fun offsetX(number: Double): Vertex2d = Vertex2d(x + number, y)

    fun offsetY(number: Double): Vertex2d = Vertex2d(x, y + number)
}
