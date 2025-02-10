package su.duvanoff.shapes.domain.service

import kotlin.reflect.KClass

interface BindService {
    fun bindTextToClass(text: String): KClass<*>
}