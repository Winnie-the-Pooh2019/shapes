package su.duvanoff.shapes.exception

import su.duvanoff.shapes.exception.type.ExceptionPriority

open class ShapeException(message: String = "", val priority: ExceptionPriority) : RuntimeException(message)