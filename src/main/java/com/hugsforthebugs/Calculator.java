package com.hugsforthebugs;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b){
        return a - b;
    }

    public int mul(int a, int b){
        //overflow check
        long tempResult = (long)a * (long)b;
        if (tempResult > Integer.MAX_VALUE) {
            throw new ArithmeticException("Overflow (Positive)!");
        }else if(tempResult < Integer.MIN_VALUE){
            throw new ArithmeticException("Overflow (Negative)!");
        }
        return a*b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }

    public double squareroot(double a) {
        if (a < 0) {
            throw new ArithmeticException("Square root of negative number");
        }
        return Math.sqrt(a);
    }
}
