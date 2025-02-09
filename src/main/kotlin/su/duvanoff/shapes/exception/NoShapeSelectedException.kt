package su.duvanoff.shapes.exception

class NoShapeSelectedException(message: String = "You did not select any shape type") :
    NoValueProvidedException(message)