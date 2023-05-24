fun main() {
    val parsedInput = ParseInput("sample_input.txt")

    val gridX = parsedInput.gridX
    val gridY = parsedInput.gridY
    val robots = parsedInput.robots

    gridX?.let { x ->
        gridY?.let { y ->
            Validation(gridX, gridY, robots).validate()
            println(MarsSurface(x, y, robots).parseRobotInstructions())
        }
    }
}
