package su.duvanoff.shapes.utils

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class IsFloatingTest {

    @Test
    fun testFloatFilter() {
        val newVal = "0.35"

        assertTrue(newVal.isFloating())
    }

    @Test
    fun testFloatFilterChar() {
        val newVal = "0.35rs"

        assertFalse(newVal.isFloating())
    }

    @Test
    fun testFloatFilterSeveralPoints() {
        val newVal = "0.35.2.6"

        assertFalse(newVal.isFloating())
    }

    @Test
    fun testFloatFilterSeveralZeros() {
        val newVal = "0000.35"

        assertFalse(newVal.isFloating())
    }
}