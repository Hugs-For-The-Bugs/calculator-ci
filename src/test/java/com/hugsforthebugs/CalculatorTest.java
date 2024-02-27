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
}
