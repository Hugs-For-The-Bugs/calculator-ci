package com.hugsforthebugs;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CalculatorTest {
    @Test
    public void addTest()
    {
        Calculator calculator = new Calculator();
        assertTrue( calculator.add(1, 1) == 2 );
    }

    @Test
    public void divideTest()
    {
        Calculator calculator = new Calculator();
        assertTrue( calculator.divide(2, 4) == 1 );
    }
}
