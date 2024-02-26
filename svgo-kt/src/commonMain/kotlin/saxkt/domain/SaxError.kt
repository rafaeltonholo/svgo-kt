package saxkt.domain

data class SaxError(
    val reason: String,
    val message: String,
    val positionTracker: PositionTracker? = null,
)

class SaxErrorException(
    error: SaxError,
    cause: Throwable? = null,
) : Exception(error.message, cause)
