fun getRobot(
    coordinates: Coordinates = Coordinates(0, 0),
    orientation: Orientation = Orientation.N,
    instructions: List<Instruction> = emptyList(),
    isLost: Boolean = false
): Robot {
    return Robot(coordinates, orientation, instructions, isLost)
}

fun mapStringToInstructionsList(s: String): List<Instruction> = s.map { Instruction.valueOf(it.toString()) }
