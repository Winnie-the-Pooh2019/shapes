package su.duvanoff.shapes.exception

import su.duvanoff.shapes.exception.type.ExceptionPriority

abstract class NoValueProvidedException(message: String? = null, override val priority: ExceptionPriority) : RuntimeException(message), ShapeException