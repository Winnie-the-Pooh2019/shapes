package su.duvanoff.shapes.domain.service

import su.duvanoff.shapes.domain.model.AbstractShape

interface DeformShapeService {
    fun calc(shape: AbstractShape): AbstractShape
}