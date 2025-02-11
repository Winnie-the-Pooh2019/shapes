package su.duvanoff.shapes.domain.model

import su.duvanoff.shapes.domain.model.type.TypeOfMetal

class ModelPrism(
    metal: TypeOfMetal,
    height: Double,
    base: Double
) : ModelShape(
    metal,
    height,
    base
)