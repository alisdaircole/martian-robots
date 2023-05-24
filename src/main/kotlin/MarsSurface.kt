class MarsSurface(private val x: Int, private val y: Int, private val robots: List<Robot>) {
    private val scentCoordinatesSet: MutableSet<Coordinates> = mutableSetOf()

    fun parseRobotInstructions(): String {
        var result = ""
        for (robot in robots) {
            for (instruction in robot.instructions) {
                val prevCoordinates = robot.coordinates
                robot.parseInstruction(instruction)

                if (isOutOfBounds(robot.coordinates)) {
                    robot.coordinates = prevCoordinates
                    if (!scentCoordinatesSet.contains(robot.coordinates)) {
                        scentCoordinatesSet.add(robot.coordinates)
                        robot.isLost = true
                        break
                    }
                }
            }
            result += robot.toString() + System.lineSeparator()
        }
        return result.trim()
    }

    private fun isOutOfBounds(coordinates: Coordinates): Boolean = coordinates.x > x || coordinates.y > y
}
