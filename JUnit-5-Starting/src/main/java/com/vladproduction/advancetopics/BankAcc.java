package com.vladproduction.advancetopics;

public class BankAcc {

    private double balance;
    private double minBalance;
    private boolean isActive;
    private String holder;

    public BankAcc(double balance, double minBalance) {
        this.balance = balance;
        this.minBalance = minBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public double withdraw(double amount){
        if(balance - amount > minBalance){
            balance -= amount;
            return amount;
        }
        else {
            throw new RuntimeException();
        }
    }

    public double deposit(double amount){
        return balance += amount;
    }

}
