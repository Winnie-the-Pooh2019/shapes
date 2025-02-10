package su.duvanoff.shapes.domain.service.impl

import su.duvanoff.shapes.domain.model.Cone
import su.duvanoff.shapes.domain.model.Cylinder
import su.duvanoff.shapes.domain.model.Parallelepiped
import su.duvanoff.shapes.domain.model.Prism
import su.duvanoff.shapes.domain.service.BindService
import kotlin.reflect.KClass

class BindServiceImpl : BindService {

    override fun bindTextToClass(text: String): KClass<*> = when {
        text.lowercase().contains("цилиндр") -> Cylinder::class

        text.lowercase().contains("конус") -> Cone::class

        text.lowercase().contains("квадрат") -> Parallelepiped::class

        text.lowercase().contains("треугольник") -> Prism::class

        else -> throw IllegalArgumentException()
    }
}