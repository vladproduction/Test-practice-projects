package com.vladproduction.exceptionthrowing;

import java.util.Arrays;
import java.util.List;

public class Cashier {

    private static final List<String> currencyList = Arrays.asList("EUR", "GBP");

    public static double validateCashier(String currency, double amount){
        if(currencyAccepted(currency) && amountIsValid(amount)){
            return amount;
        }
        return -1;
    }

    private static boolean currencyAccepted(String currency) {
        if(!currencyList.contains(currency)){
            throw new IllegalArgumentException("Currency: " + currency + " not accepted");
        }
        return true;
    }

    private static boolean amountIsValid(double amount) {
        if(amount < 0){
            throw new InvalidAmountException("Amount must be greater than 0.");
        }
        return true;
    }

}


















