package saxkt.domain

data class PositionTracker(
    val position: Int = 0,
    val line: Int = 0,
    val column: Int = 0,
)

fun PositionTracker?.copy(
    position: Int? = null,
    line: Int? = null,
    column: Int? = null,
): PositionTracker = this?.copy(
    position = position ?: this.position,
    line = line ?: this.line,
    column = column ?: this.column,
) ?: PositionTracker(
    position = position ?: 0,
    line = line ?: 0,
    column = column ?: 0,
)
