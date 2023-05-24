import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ValidationTest {

    @Test
    fun validateThrowsExceptionWhenGridCoordinateLessThanZero() {
        val validation = Validation(-1, 5, listOf())

        val expected = "Grid coordinates must be greater than or equal to 0"
        val actual = Assertions.assertThrows(Exception::class.java) {
            validation.validate()
        }

        assertEquals(expected, actual.message)
    }

    @Test
    fun validateThrowsExceptionWhenGridCoordinateExceedMaxSize() {
        val validation = Validation(1, 51, listOf())

        val expected = "Grid coordinates must be less than or equal to 50"
        val actual = Assertions.assertThrows(Exception::class.java) {
            validation.validate()
        }

        assertEquals(expected, actual.message)
    }

    @Test
    fun validatePassesWithValidGridCoordinates() {
        val validation = Validation(10, 5, listOf())

        validation.validate()
    }

    @Test
    fun validateThrowsExceptionWhenInstructionsExceedMaxSize() {
        val robot = getRobot(instructions = mapStringToInstructionsList(("L".repeat(100))))
        val validation = Validation(10, 5, listOf(robot))

        val expected = "Instruction size must be less than 100"
        val actual = Assertions.assertThrows(Exception::class.java) {
            validation.validate()
        }

        assertEquals(expected, actual.message)
    }

    @Test
    fun validatePassesWithValidInstructionsSize() {
        val robot = getRobot(instructions = mapStringToInstructionsList(("L".repeat(20))))
        val validation = Validation(10, 5, listOf(robot))

        validation.validate()
    }

    @Test
    fun validateThrowsExceptionWhenRobotCoordinatesOutsideGrid() {
        val robot = getRobot(coordinates = (Coordinates(100, 1)))
        val validation = Validation(10, 5, listOf(robot))

        val expected = "All robots must start within the grid"
        val actual = Assertions.assertThrows(Exception::class.java) {
            validation.validate()
        }

        assertEquals(expected, actual.message)
    }

    @Test
    fun validateThrowsExceptionWhenRobotCoordinatesLessThanZero() {
        val robot = getRobot(coordinates = (Coordinates(1, -1)))
        val validation = Validation(10, 5, listOf(robot))

        val expected = "Robot coordinates must be greater than or equal to 0"
        val actual = Assertions.assertThrows(Exception::class.java) {
            validation.validate()
        }

        assertEquals(expected, actual.message)
    }

    @Test
    fun validatePassesWithValidRobotCoordinates() {
        val robot = getRobot(coordinates = Coordinates(3, 3))
        val validation = Validation(10, 5, listOf(robot))

        validation.validate()
    }
}
