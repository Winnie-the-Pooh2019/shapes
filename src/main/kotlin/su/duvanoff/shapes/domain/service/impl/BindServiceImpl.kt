package su.duvanoff.shapes.domain.service.impl

import su.duvanoff.shapes.domain.model.Cone
import su.duvanoff.shapes.domain.model.Cylinder
import su.duvanoff.shapes.domain.model.Parallelepiped
import su.duvanoff.shapes.domain.model.Prism
import su.duvanoff.shapes.domain.service.BindService

class BindServiceImpl : BindService {

    override fun bindTextToClass(text: String): Class<*> = when {
        text.lowercase().contains("цилиндр") -> Cylinder::class.java

        text.lowercase().contains("конус") -> Cone::class.java

        text.lowercase().contains("квадрат") -> Parallelepiped::class.java

        text.lowercase().contains("треугольник") -> Prism::class.java

        else -> throw IllegalArgumentException()
    }
}