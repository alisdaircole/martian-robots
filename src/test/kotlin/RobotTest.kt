import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


class RobotTest {
    @Test
    fun parseInstructionForwardUpdatesCoordinates() {
        val instruction = Instruction.F
        val expected = getRobot(coordinates = Coordinates(0, 1), instructions = listOf(instruction))

        val actual = getRobot(coordinates = Coordinates(0, 0), instructions = listOf(instruction))
        actual.parseInstruction(instruction)

        assertEquals(expected, actual)
    }

    @Test
    fun parseInstructionLeftUpdatesOrientation() {
        val instruction = Instruction.L
        val expected = getRobot(orientation = Orientation.W)

        val actual = getRobot(orientation = Orientation.N)
        actual.parseInstruction(instruction)

        assertEquals(expected, actual)
    }

    @Test
    fun parseInstructionRightUpdatesOrientation() {
        val instruction = Instruction.R
        val expected = getRobot(orientation = Orientation.E)

        val actual = getRobot(orientation = Orientation.N)
        actual.parseInstruction(instruction)

        assertEquals(expected, actual)
    }

    @Test
    fun toStringReturnsExpectedFormat() {
        val robot = getRobot()

        val expected = "0 0 N"
        val actual = robot.toString()

        assertEquals(expected, actual)
    }

    @Test
    fun toStringWithLostRobotReturnsExpectedFormat() {
        val robot = getRobot(isLost = true)

        val expected = "0 0 N LOST"
        val actual = robot.toString()

        assertEquals(expected, actual)
    }
}
