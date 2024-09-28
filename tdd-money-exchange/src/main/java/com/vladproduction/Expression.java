package com.vladproduction;

public interface Expression {
    Money reduce(Bank bank, String to);

    Expression plus(Expression addmend);

    Expression times(int multiply);
}
