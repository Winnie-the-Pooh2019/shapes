package su.duvanoff.shapes.exception

class NoMetalSelectedException(message: String = "You did not select any type of metal") :
    NoValueProvidedException(message)