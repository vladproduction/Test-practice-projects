package com.vladproduction.utils;

public class CurrencyConverter {

    private static final double EURO_TO_USD_RATE = 1.1;
    private static final double EURO_TO_CNY_RATE = 7.2;

    public static double toUsd(double euroAmount) {
        return euroAmount * EURO_TO_USD_RATE;
    }
    public static double toCny(double euroAmount) {
        return euroAmount * EURO_TO_CNY_RATE;
    }



}
