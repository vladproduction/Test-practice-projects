package com.vladproduction.demomath;

public class NumberHelperMath {

    public double addition(int num1, int num2){
        return num1 + num2;
    }
    public double additionForDebugging(int num1, int num2){
        return num1 + num2; //just to see how to debug by breakpoint or evaluate expression
        //(assume we have a bug: num1 + num1)
    }

    public double subtract(int num1, int num2){
        return num1 - num2; //just to see how code coverage work (we are not cover this method)
    }

}
