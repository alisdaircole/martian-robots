import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MarsSurfaceTest {
    @Test
    fun parseRobotInstructions() {
        val robot1 = getRobot(Coordinates(1, 1), Orientation.E, mapStringToInstructionsList("RFRFRFRF"))
        val robot2 = getRobot(Coordinates(3, 2), Orientation.N, mapStringToInstructionsList("FRRFLLFFRRFLL"))
        val robot3 = getRobot(Coordinates(0, 3), Orientation.W, mapStringToInstructionsList("LLFFFLFLFL"))
        val marsSurface = MarsSurface(5, 3, listOf(robot1, robot2, robot3))

        val expected =
            """
                1 1 E
                3 3 N LOST
                2 3 S
            """.trimIndent()
        val actual = marsSurface.parseRobotInstructions()

        assertEquals(expected, actual)
    }
}
