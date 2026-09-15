import org.example.Calculator
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test
import kotlin.test.assertNotEquals

class CalculatorTest {
    private val calculator = Calculator()

    @Test
    fun testAddPositiveNumbers() {
        val result = calculator.add(2, 3)
        val expected = 5
        assertEquals(expected, result)
    }

    @Test
    fun testAddNegativeNumbers() {
        val result = calculator.add(-2, -3)
        val expected = -5
        assertEquals(expected, result)
    }

    @Test
    fun testAddMixedNumbers() {
        val result = calculator.add(2, -3)
        val expected = -1
        assertEquals(expected, result)
    }

}
