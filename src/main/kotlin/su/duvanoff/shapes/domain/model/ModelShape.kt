package su.duvanoff.shapes.domain.model

import su.duvanoff.shapes.domain.model.type.TypeOfMetal

sealed class ModelShape(
    val metal: TypeOfMetal,
    val height: Double = 1.0,
    val base: Double = 1.0,
)
