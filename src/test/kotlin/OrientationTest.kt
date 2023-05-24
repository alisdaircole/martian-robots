import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class OrientationTest {
    @Test
    fun northWithRightReturnsEast() {
        val expected = Orientation.E
        val actual = Orientation.N.right()

        assertEquals(expected, actual)
    }

    @Test
    fun eastWithLeftReturnsNorth() {
        val expected = Orientation.N
        val actual = Orientation.E.left()

        assertEquals(expected, actual)
    }

    @Test
    fun leftWithNorthReturnsWest() {
        val expected = Orientation.W
        val actual = Orientation.N.left()

        assertEquals(expected, actual)
    }

    @Test
    fun rightWithWestReturnsNorth() {
        val expected = Orientation.N
        val actual = Orientation.W.right()

        assertEquals(expected, actual)
    }

    @Test
    fun northWithTwoRightReturnsSouth() {
        val expected = Orientation.S
        val actual = Orientation.N.right().right()

        assertEquals(expected, actual)
    }

    @Test
    fun northWithTwoLeftReturnsSouth() {
        val expected = Orientation.S
        val actual = Orientation.N.left().left()

        assertEquals(expected, actual)
    }

    @Test
    fun northWithLeftThenRightReturnsNorth() {
        val expected = Orientation.N
        val actual = Orientation.N.left().right()

        assertEquals(expected, actual)
    }

    @Test
    fun toStringReturnsAbbreviatedOrientation() {
        val expected = "N"
        val actual = Orientation.N.toString()

        assertEquals(expected, actual)
    }
}
