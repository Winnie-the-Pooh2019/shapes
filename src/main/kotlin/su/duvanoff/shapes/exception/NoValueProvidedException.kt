package su.duvanoff.shapes.exception

import su.duvanoff.shapes.exception.type.ExceptionPriority

open class NoValueProvidedException(message: String = "", priority: ExceptionPriority) :
    ShapeException(message, priority)