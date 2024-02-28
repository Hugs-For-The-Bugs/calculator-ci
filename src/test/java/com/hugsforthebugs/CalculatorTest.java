package com.hugsforthebugs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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

    @Test(expected = ArithmeticException.class)
    public void multiplyTest(){
        Calculator calculator = new Calculator();
        long overflowNum = Long.valueOf("4611686014132420609");
        assertTrue(calculator.mul(0,0) == 0);
        assertFalse(calculator.mul(2147483647, 2147483647) == overflowNum); //expecting this multiplication to overflow and throw ArithmeticException
        assertFalse(calculator.mul(-2147483647, 2147483647) == -overflowNum); //expecting this multiplication to overflow and throw ArithmeticException
    }

    @Test
    public void divideTest()
    {
        Calculator calculator = new Calculator();
        assertTrue( calculator.divide(4, 2) == 2 );
    }

    @Test
    public void squarerootTest()
    {
        Calculator calculator = new Calculator();
        assertEquals(2.0, calculator.squareroot(4), 0.000001);
        // test for negative numbers
        try {
            calculator.squareroot(-1);
        } catch (ArithmeticException e) {
            assertEquals("Square root of negative number", e.getMessage());
        }
    }
}
