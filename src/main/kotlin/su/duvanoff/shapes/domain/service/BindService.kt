package su.duvanoff.shapes.domain.service

interface BindService {
    fun bindTextToClass(text: String): Class<*>
}