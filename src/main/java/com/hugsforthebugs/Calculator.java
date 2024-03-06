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
    
    public long factorial(int n){
        // 25 - Normal Maximum
        // 26~65 - Overflow Long
        // >66 - Return 0
        if (n<0) {
            throw new ArithmeticException("Input number must be greater or equal to 0");
        }
        if (n>25) {
            throw new ArithmeticException("Result overflow max value of long type");
        }
        if (n == 0){
            // arbitrarily return 1 for non-positive numbers
            return 1;
        }else {
          return (n * factorial(n-1));
        }
    } 
    
    public double sin (double x){
        if (x == Double.POSITIVE_INFINITY || x == Double.NEGATIVE_INFINITY || x == Double.NaN) {
            return Double.NaN;
        }
        // the parameter is assumed to be in degree
        // so we first convert it into radians
        double x_in_radians = Math.toRadians(x);
        return Math.sin(x_in_radians);
    }

    public int mod(int a, int b) {
        if (b == 0) {
          throw new ArithmeticException("Division by zero");
        }
        return a % b;
    }
    public double power(double a, int b) {
        if (b == 0) {
        return 1; 
    }
    
        double result = 1.0;
        int absB = Math.abs(b); 

       for (int i = 0; i < absB; i++) {
       result *= a;
    }
    
  
        if (b < 0) {
        result = 1.0 / result;
    }
    
    return result;
}

}
