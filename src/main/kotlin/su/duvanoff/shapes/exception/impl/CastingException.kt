package su.duvanoff.shapes.exception.impl

import su.duvanoff.shapes.exception.ShapeException
import su.duvanoff.shapes.exception.type.ExceptionPriority

class CastingException(message: String = "Icorrect cast", priority: ExceptionPriority = ExceptionPriority.MODERATE) :
    ShapeException(message, priority)