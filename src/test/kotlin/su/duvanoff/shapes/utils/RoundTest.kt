package su.duvanoff.shapes.utils

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RoundTest {

    @Test
    fun testRound() {
        val pi = 3.14159265359
        val expPi = 3.14

        assertEquals(expPi, pi.round(2))
    }

    @Test
    fun testRoundNoDigits() {
        val pi = 3.14159265359
        val expPi = 3.0

        assertEquals(expPi, pi.round())
    }

    @Test
    fun testRoundNegativeDecimals() {
        val pi = 3.14159265359

        assertThrows(IllegalArgumentException::class.java) {
            pi.round(-1)
        }
    }
}