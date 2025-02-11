package su.duvanoff.shapes.domain.drawable.primitive

data class Vertex3d(val x: Double, val y: Double, val z: Double) : Vertex<Double> {

    override fun to(other: Vertex<Double>): Edge<Double, *> = when(other) {
        is Vertex3d -> Edge3d(this, other)
        is Vertex2d -> Edge2d(Vertex2d(this.x, this.y), other)
    }

    fun offsetX(number: Double): Vertex3d = Vertex3d(x + number, y, z)

    fun offsetY(number: Double): Vertex3d = Vertex3d(x, y + number, z)

    fun offsetZ(number: Double): Vertex3d = Vertex3d(x, y, z + number)
}
