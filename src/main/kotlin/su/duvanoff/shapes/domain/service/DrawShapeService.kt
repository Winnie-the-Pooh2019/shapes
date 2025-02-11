package su.duvanoff.shapes.domain.service

import su.duvanoff.shapes.domain.model.ModelShape
import su.duvanoff.shapes.domain.drawable.type.Color

interface DrawShapeService {
    fun draw(shape: ModelShape, color: Color)
}