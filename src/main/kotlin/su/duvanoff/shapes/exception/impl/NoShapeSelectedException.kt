package su.duvanoff.shapes.exception.impl

import su.duvanoff.shapes.exception.NoValueProvidedException
import su.duvanoff.shapes.exception.type.ExceptionPriority

class NoShapeSelectedException(
    message: String = "You did not select any shape type",
    priority: ExceptionPriority = ExceptionPriority.NORMAL
) :
    NoValueProvidedException(message, priority)