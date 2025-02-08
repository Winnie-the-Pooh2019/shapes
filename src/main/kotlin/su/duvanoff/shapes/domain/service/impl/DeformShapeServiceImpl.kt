package su.duvanoff.shapes.domain.service.impl

import su.duvanoff.shapes.domain.model.*
import su.duvanoff.shapes.domain.service.DeformShapeService
import su.duvanoff.shapes.utils.round
import kotlin.math.pow
import kotlin.math.sqrt

class DeformShapeServiceImpl : DeformShapeService {

    override fun calc(shape: AbstractShape): AbstractShape = when (shape) {
        is Cylinder -> {
            val deformedHeight = (shape.height - shape.height / shape.metal.coefficient).round(3)
            val deformedBase = (2 * sqrt(shape.height * (shape.base / 2).pow(2)) / deformedHeight).round(3)

            Cylinder(
                metal = shape.metal,
                height = deformedHeight,
                base = deformedBase
            )
        }

        is Parallelepiped -> {
            val deformedHeight = (shape.height - shape.height / shape.metal.coefficient).round(3)
            val deformedBase = (sqrt(shape.height * shape.base.pow(2))).round(3)

            Parallelepiped(
                metal = shape.metal,
                height = deformedHeight,
                base = deformedBase
            )
        }

        is Prism -> {
            val deformedHeight = (shape.height - shape.height / shape.metal.coefficient).round(3)
            val deformedBase = (shape.base - shape.base / shape.metal.coefficient).round(3)

            Prism(
                metal = shape.metal,
                height = deformedHeight,
                base = deformedBase
            )
        }

        is Cone -> {
            val deformedHeight = (shape.height - shape.height / shape.metal.coefficient).round(3)
            val deformedBase = (shape.base - shape.base / shape.metal.coefficient).round(3)

            Cone(
                metal = shape.metal,
                height = deformedHeight,
                base = deformedBase
            )
        }
    }
}