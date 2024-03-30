package com.hugsforthebugs;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


// This test if for the fourArithmetic method witch integrates all the basic operations
public class IntegrationTest {
    Calculator testCalculator = new Calculator();

    @Test
    public void addIntegrationTest() {
        assertEquals(3, testCalculator.applyOp('+', 2, 1), 0);
        assertEquals(9, testCalculator.fourArithmetic("2+3+4"), 0);
    }

    @Test
    public void subIntegrationTest() {
        assertEquals(1, testCalculator.applyOp('-', 1, 2), 0);
        assertEquals(5, testCalculator.fourArithmetic("10-3-2"), 0);
    }

    @Test
    public void mulIntegrationTest() {
        assertEquals(2, testCalculator.applyOp('*', 2, 1), 0);
        assertEquals(24, testCalculator.fourArithmetic("2*3*4"), 0);
    }

    @Test
    public void divIntegrationTest() {
        assertEquals(2, testCalculator.applyOp('/', 1, 2), 0);
        assertEquals(2, testCalculator.fourArithmetic("10/5"), 0);
    }

    @Test
    public void complexIntegrationTest() {
        assertEquals(5, testCalculator.fourArithmetic("2+3-1+1*2/2"), 0);
        assertEquals(8, testCalculator.fourArithmetic("2+4-(4-5)*8/4"), 0);
        assertEquals(-8, testCalculator.fourArithmetic("2+9/3-(3+4*6/6)*8/4+1"), 0);
    }

}
