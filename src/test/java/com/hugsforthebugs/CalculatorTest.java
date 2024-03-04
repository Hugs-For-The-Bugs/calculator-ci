package com.hugsforthebugs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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

    @Test
    public void factorialTest(){
        Calculator calculator = new Calculator();
        assertEquals(1, calculator.factorial(0), 0.000001); // test for 0
        // test for positive number
        assertEquals(3628800, calculator.factorial(10),0.00001);
        
        // test for positive number that will cause overflow
        try {
            calculator.factorial(100);
        } catch (ArithmeticException e) {
            assertEquals("Result overflow max value of long type", e.getMessage());
        }

        // test for negative number
        try {
            calculator.factorial(-1);
        } catch (ArithmeticException e) {
            assertEquals("Input number must be greater or equal to 0", e.getMessage());
        }
    }

    @Test
    public void mod_ok() {
        Calculator calculator = new Calculator();
        assertTrue( calculator.mod(5, 2) == 1 );
        assertTrue( calculator.mod(4, 2) == 0 );
    }

    @Test
    public void mod_ng() {
        Calculator calculator = new Calculator();
        try {
            calculator.mod(1, 0);
            fail("No ArithmeticException");
        } catch (ArithmeticException e) {
            assertEquals("Division by zero", e.getMessage());
        }
    }
    
}
