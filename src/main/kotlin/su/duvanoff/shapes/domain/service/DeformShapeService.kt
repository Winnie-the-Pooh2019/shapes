package su.duvanoff.shapes.domain.service

import su.duvanoff.shapes.domain.model.ModelShape

interface DeformShapeService {
    fun calc(shape: ModelShape): ModelShape
}