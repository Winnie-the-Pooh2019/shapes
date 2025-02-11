package su.duvanoff.shapes.domain.service.impl

import su.duvanoff.shapes.domain.model.ModelCone
import su.duvanoff.shapes.domain.model.ModelCylinder
import su.duvanoff.shapes.domain.model.ModelParallelepiped
import su.duvanoff.shapes.domain.model.ModelPrism
import su.duvanoff.shapes.domain.service.BindService
import kotlin.reflect.KClass

class BindServiceImpl : BindService {

    override fun bindTextToClass(text: String): KClass<*> = when {
        text.lowercase().contains("цилиндр") -> ModelCylinder::class

        text.lowercase().contains("конус") -> ModelCone::class

        text.lowercase().contains("квадрат") -> ModelParallelepiped::class

        text.lowercase().contains("треугольник") -> ModelPrism::class

        else -> throw IllegalArgumentException()
    }
}