package com.vladproduction.demomath;

/**
 * class to present approaches to testing cases
 * */
public class CalculateMethods {

    /**
     * In Java, dividing a floating-point number by zero does not throw an exception like it does for integers.
     *
     * Instead, it results in special values:
     *
     * Dividing a positive number by zero yields positive infinity (Infinity).
     * Dividing a negative number by zero yields negative infinity (-Infinity).
     * Dividing zero by zero results in NaN (Not a Number).
     *
     * so, we have to have if() to catch our exception;
     * */
    public double divide(double numb1, double numb2){
        if (numb2 == 0.0) {
            throw new ArithmeticException("Division by zero");
        }
        return numb1 / numb2;
    }

    /**
     * try to divide integers
     *
     * so, we are not using if statements to catch exception by divide '0';
     * */
    public int divideIntegers(int num1, int num2){
        return num1 / num2;
    }

}
