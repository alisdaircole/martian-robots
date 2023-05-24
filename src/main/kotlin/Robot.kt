data class Robot(
    var coordinates: Coordinates,
    private var orientation: Orientation,
    val instructions: List<Instruction>,
    var isLost: Boolean = false,
) {
    fun parseInstruction(instruction: Instruction) = when (instruction) {
        Instruction.F -> coordinates = applyForwardMove(orientation.xForwardMove, orientation.yForwardMove)
        Instruction.L -> orientation = orientation.left()
        Instruction.R -> orientation = orientation.right()
    }

    private fun applyForwardMove(x: Int, y: Int): Coordinates = Coordinates(coordinates.x + x, coordinates.y + y)

    override fun toString(): String = "$coordinates $orientation ${isLostString()}".trim()

    private fun isLostString(): String = if (isLost) "LOST" else ""
}
