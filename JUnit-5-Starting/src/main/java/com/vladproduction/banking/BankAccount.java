package com.vladproduction.banking;

public class BankAccount {

    private double balance;
    private final double minimumBalance;
    private boolean active = true; //default value is "true", as bank acc is active after creation
    private String holderName;

    public BankAccount(double balance, double minimumBalance) {
        this.balance = balance;
        this.minimumBalance = minimumBalance;
    }

    public double getBalance() {
        return balance;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public double withdraw(double amount){
        if(balance - amount > minimumBalance){
            balance -= amount;
            return amount;
        }
        else {
            throw new RuntimeException();
        }
    }

    public double deposit(double amount){
        //org.opentest4j.AssertionFailedError: execution exceeded timeout of 0 ms by 111 ms
        //added try/catch for demonstration assertTimeout
        /*try{
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }*/
        return balance += amount;
    }
}
