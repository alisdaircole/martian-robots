class Validation(private val gridX: Int, private val gridY: Int, private val robots: List<Robot>) {
    private val maxGridSize = 50
    private val maxInstructionSize = 100

    fun validate() {
        validGridCoordinates()
        validInstructionSize()
        validRobotStartingPosition()
    }

    private fun validGridCoordinates() {
        if (gridX > maxGridSize || gridY > maxGridSize) {
            throw Exception("Grid coordinates must be less than or equal to $maxGridSize")
        }
        if (gridX < 0 || gridY < 0) {
            throw Exception("Grid coordinates must be greater than or equal to 0")
        }
    }

    private fun validInstructionSize() {
        if (robots.any { it.instructions.size >= maxInstructionSize }) {
            throw Exception("Instruction size must be less than $maxInstructionSize")
        }
    }

    private fun validRobotStartingPosition() {
        if (robots.any { it.coordinates.x > gridX || it.coordinates.y > gridY }) {
            throw Exception("All robots must start within the grid")
        }
        if (robots.any { it.coordinates.x < 0 || it.coordinates.y < 0 }) {
            throw Exception("Robot coordinates must be greater than or equal to 0")
        }
    }
}
