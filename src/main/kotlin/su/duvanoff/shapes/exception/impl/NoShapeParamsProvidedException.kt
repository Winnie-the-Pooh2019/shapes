package su.duvanoff.shapes.exception.impl

import su.duvanoff.shapes.exception.NoValueProvidedException

class NoShapeParamsProvidedException(message: String = "Shape params cannot be empty") :
    NoValueProvidedException(message)