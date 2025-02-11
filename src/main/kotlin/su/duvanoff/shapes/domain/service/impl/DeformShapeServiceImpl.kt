package su.duvanoff.shapes.domain.service.impl

import su.duvanoff.shapes.domain.model.*
import su.duvanoff.shapes.domain.service.DeformShapeService
import su.duvanoff.shapes.utils.round
import kotlin.math.pow
import kotlin.math.sqrt

class DeformShapeServiceImpl : DeformShapeService {

    override fun calc(shape: ModelShape): ModelShape = when (shape) {
        is ModelCylinder -> {
            val deformedHeight = (shape.height - shape.height / shape.metal.coefficient).round(3)
            val deformedBase = (2 * sqrt(shape.height * (shape.base / 2).pow(2)) / deformedHeight).round(3)

            ModelCylinder(
                metal = shape.metal,
                height = deformedHeight,
                base = deformedBase
            )
        }

        is ModelParallelepiped -> {
            val deformedHeight = (shape.height - shape.height / shape.metal.coefficient).round(3)
            val deformedBase = (sqrt(shape.height * shape.base.pow(2))).round(3)

            ModelParallelepiped(
                metal = shape.metal,
                height = deformedHeight,
                base = deformedBase
            )
        }

        is ModelPrism -> {
            val deformedHeight = (shape.height - shape.height / shape.metal.coefficient).round(3)
            val deformedBase = (shape.base - shape.base / shape.metal.coefficient).round(3)

            ModelPrism(
                metal = shape.metal,
                height = deformedHeight,
                base = deformedBase
            )
        }

        is ModelCone -> {
            val deformedHeight = (shape.height - shape.height / shape.metal.coefficient).round(3)
            val deformedBase = (shape.base - shape.base / shape.metal.coefficient).round(3)

            ModelCone(
                metal = shape.metal,
                height = deformedHeight,
                base = deformedBase
            )
        }
    }
}