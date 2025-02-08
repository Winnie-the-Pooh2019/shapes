package su.duvanoff.shapes.domain.service

import su.duvanoff.shapes.domain.model.AbstractShape

interface DrawShapeService {
    fun draw(shape: AbstractShape)
}