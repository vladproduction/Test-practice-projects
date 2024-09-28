package com.vladproduction;

public class Money implements Expression{
    protected final int amount;
    protected final String currency;
    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    protected String currency() {
        return currency;
    }

    public static Money dollar(int amount){
        return new Money(amount, "USD");
    }

    public static Money frank(int amount){
        return new Money(amount, "CHF");
    }

    public boolean equals(Object o){
        Money money = (Money) o;
        return amount == money.amount //if amount are ==
                && this.currency == money.currency; //if same classes present
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }
    @Override
    public Money reduce(Bank bank, String to){
        return new Money(amount / bank.rate(this.currency, to), to);
    }

    @Override
    public Expression times(int multiply){
        return new Money(amount * multiply, this.currency);
    }

    @Override
    public Expression plus(Expression addmend){
        return new Sum(this, addmend);
    }

}
