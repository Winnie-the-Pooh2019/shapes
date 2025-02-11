package su.duvanoff.shapes.domain.drawable.type

data class Color(
    val red: Int,
    val green: Int,
    val blue: Int,
    val alpha: Int = 100
) {
    companion object {
        val RED = Color(255, 0, 0)
        val GREEN = Color(0, 255, 0)
        val BLUE = Color(0, 0, 255)
        val BLACK = Color(0, 0, 0)
    }
}
