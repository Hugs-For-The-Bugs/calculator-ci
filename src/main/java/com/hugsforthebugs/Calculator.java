package com.hugsforthebugs;

import java.util.Stack;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int mul(int a, int b) {
        // overflow check
        long tempResult = (long) a * (long) b;
        if (tempResult > Integer.MAX_VALUE) {
            throw new ArithmeticException("Overflow (Positive)!");
        } else if (tempResult < Integer.MIN_VALUE) {
            throw new ArithmeticException("Overflow (Negative)!");
        }
        return a * b;
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

    public long factorial(int n) {
        // 25 - Normal Maximum
        // 26~65 - Overflow Long
        // >66 - Return 0
        if (n < 0) {
            throw new ArithmeticException("Input number must be greater or equal to 0");
        }
        if (n > 25) {
            throw new ArithmeticException("Result overflow max value of long type");
        }
        if (n == 0) {
            // arbitrarily return 1 for non-positive numbers
            return 1;
        } else {
            return (n * factorial(n - 1));
        }
    }

    public double sin(double x) {
        if (x == Double.POSITIVE_INFINITY || x == Double.NEGATIVE_INFINITY || x == Double.NaN) {
            return Double.NaN;
        }
        // the parameter is assumed to be in degree
        // so we first convert it into radians
        double x_in_radians = Math.toRadians(x);
        return Math.sin(x_in_radians);
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

    public int mod(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a % b;
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    // A method for executing a sequence of complex operations from a string (except
    // for square root and factorial)
    public int fourArithmetic(String expression) {
        Stack<Integer> numbers = new Stack<>();
        Stack<Character> operations = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c)) {
                // Extend this to handle multi-digit numbers
                int num = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    num = num * 10 + (expression.charAt(i) - '0');
                    i++;
                }
                numbers.push(num);
                i--; // Since the loop increments i, decrement it here after number parsing
            } else if (c == '(') {
                operations.push(c);
            } else if (c == ')') {
                while (operations.peek() != '(') {
                    numbers.push(applyOp(operations.pop(), numbers.pop(), numbers.pop()));
                }
                operations.pop();
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!operations.isEmpty() && hasPrecedence(c, operations.peek())) {
                    numbers.push(applyOp(operations.pop(), numbers.pop(), numbers.pop()));
                }
                operations.push(c);
            }
        }

        while (!operations.isEmpty()) {
            numbers.push(applyOp(operations.pop(), numbers.pop(), numbers.pop()));
        }

        return numbers.pop();
    }

    public boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        return true;
    }

    public int applyOp(char op, int b, int a) {
        switch (op) {
            case '+':
                return add(a, b);
            case '-':
                return sub(a, b);
            case '*':
                return mul(a, b);
            case '/':
                if (b == 0)
                    throw new UnsupportedOperationException("Cannot divide by zero");
                return divide(a, b);
        }
        throw new UnsupportedOperationException("Unsupported operation " + op);
    }

}
