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
    public void subTest()
    {
        Calculator calculator = new Calculator();
        assertTrue(calculator.sub(1,1) == 0);
         
    }

    @Test
    public void divideTest()
    {
        Calculator calculator = new Calculator();
        assertTrue( calculator.divide(4, 2) == 2 );
    }
}
