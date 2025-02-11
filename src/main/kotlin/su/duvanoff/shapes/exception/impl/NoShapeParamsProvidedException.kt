package su.duvanoff.shapes.exception.impl

import su.duvanoff.shapes.exception.NoValueProvidedException
import su.duvanoff.shapes.exception.type.ExceptionPriority

class NoShapeParamsProvidedException(
    message: String = "Shape params cannot be empty",
    priority: ExceptionPriority = ExceptionPriority.NORMAL
) :
    NoValueProvidedException(message, priority)