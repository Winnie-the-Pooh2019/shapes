package su.duvanoff.shapes.exception.impl

import su.duvanoff.shapes.exception.NoValueProvidedException

class NoMetalSelectedException(message: String = "You did not select any type of metal") :
    NoValueProvidedException(message)