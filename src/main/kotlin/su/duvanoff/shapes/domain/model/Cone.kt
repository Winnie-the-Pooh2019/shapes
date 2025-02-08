package su.duvanoff.shapes.domain.model

import su.duvanoff.shapes.domain.model.type.TypeOfMetal

class Cone(
    metal: TypeOfMetal,
    height: Double,
    base: Double
) : AbstractShape(
    metal,
    height,
    base
)