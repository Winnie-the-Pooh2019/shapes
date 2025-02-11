package su.duvanoff.shapes.domain.service.impl

import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import su.duvanoff.shapes.domain.model.ModelShape
import su.duvanoff.shapes.domain.service.DrawShapeService
import su.duvanoff.shapes.domain.drawable.type.Color
import su.duvanoff.shapes.domain.drawable.type.FxColor

class DrawShapeServiceImpl(
    private val canvas: Canvas
) : DrawShapeService {
    
    private val graphicsContext: GraphicsContext = canvas.graphicsContext2D

    override fun draw(shape: ModelShape, color: Color) {
        // Устанавливаем черный цвет для линий
        graphicsContext.stroke = color.toFxColor()
        graphicsContext.lineWidth = 4.0

        // Центр холста
        val centerX = canvas.width / 2
        val centerY = canvas.height / 2

        // Смещение для размещения куба в центре
        val offsetX = 50.0
        val offsetY = 50.0

        // Координаты вершин куба относительно центра
        val vertices = listOf(
            Pair(centerX - offsetX, centerY - offsetY),   // A
            Pair(centerX + offsetX, centerY - offsetY),   // B
            Pair(centerX + offsetX, centerY + offsetY),   // C
            Pair(centerX - offsetX, centerY + offsetY),   // D
            Pair(centerX - offsetX, centerY - offsetY),   // E
            Pair(centerX + offsetX, centerY - offsetY),   // F
            Pair(centerX + offsetX, centerY + offsetY),   // G
            Pair(centerX - offsetX, centerY + offsetY)    // H
        )

        // Рисуем ребра куба
        drawLine(graphicsContext, vertices[0], vertices[1]) // AB
        drawLine(graphicsContext, vertices[1], vertices[2]) // BC
        drawLine(graphicsContext, vertices[2], vertices[3]) // CD
        drawLine(graphicsContext, vertices[3], vertices[0]) // DA

        drawLine(graphicsContext, vertices[4], vertices[5]) // EF
        drawLine(graphicsContext, vertices[5], vertices[6]) // FG
        drawLine(graphicsContext, vertices[6], vertices[7]) // GH
        drawLine(graphicsContext, vertices[7], vertices[4]) // HE

        drawLine(graphicsContext, vertices[0], vertices[4]) // AE
        drawLine(graphicsContext, vertices[1], vertices[5]) // BF
        drawLine(graphicsContext, vertices[2], vertices[6]) // CG
        drawLine(graphicsContext, vertices[3], vertices[7]) // DH
    }

    private fun drawLine(gc: GraphicsContext, p1: Pair<Double, Double>, p2: Pair<Double, Double>) {
        gc.strokeLine(p1.first, p1.second, p2.first, p2.second)
    }

    private fun Color.toFxColor(): FxColor = FxColor.rgb(this.red, this.green, this.blue, this.alpha / 100.0)
}