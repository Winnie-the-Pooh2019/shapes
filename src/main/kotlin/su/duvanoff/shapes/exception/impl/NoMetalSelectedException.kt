package su.duvanoff.shapes.exception.impl

import su.duvanoff.shapes.exception.NoValueProvidedException
import su.duvanoff.shapes.exception.type.ExceptionPriority

class NoMetalSelectedException(
    message: String = "You did not select any type of metal",
    priority: ExceptionPriority = ExceptionPriority.NORMAL
) :
    NoValueProvidedException(message, priority)