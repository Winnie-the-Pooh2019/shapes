package su.duvanoff.shapes.exception

import su.duvanoff.shapes.exception.type.ExceptionPriority

interface ShapeException {
    val priority: ExceptionPriority
}