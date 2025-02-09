package su.duvanoff.shapes.exception

class NoShapeParamsProvidedException(message: String = "Shape params cannot be empty") :
    NoValueProvidedException(message)