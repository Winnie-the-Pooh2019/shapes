package su.duvanoff.shapes.exception.impl

import su.duvanoff.shapes.exception.NoValueProvidedException

class NoShapeSelectedException(message: String = "You did not select any shape type") :
    NoValueProvidedException(message)