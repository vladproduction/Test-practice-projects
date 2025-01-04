package com.vladproduction.advancetopics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.DayOfWeek;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(BankAccParameterResolver.class)
public class BankAccParameterizedTestTest {

    @ParameterizedTest
    @ValueSource(ints = {400,500,800,1000,1500})
    @DisplayName("deposit with source params")
    void depositTest(int amount, BankAcc bankAcc) {
        bankAcc.deposit(amount);
        assertEquals(amount, bankAcc.getBalance());
    }

    @ParameterizedTest
    @EnumSource(value = DayOfWeek. class, names = {"TUESDAY", "THURSDAY"})
    public void testDayOfWeek(DayOfWeek day){
        assertTrue(day.toString().startsWith("T"));
    }

    @ParameterizedTest
    @CsvSource({"100, John", "200, Nick", "300, Mike"})
    public void depositAndNameTest(double amount, String name, BankAcc bankAcc){
        bankAcc.deposit(amount);
        bankAcc.setHolder(name);
        assertEquals(amount, bankAcc.getBalance());
        assertEquals(name, bankAcc.getHolder());
    }

    @ParameterizedTest

    @CsvFileSource(resources = "/details.csv", delimiter = ',')
    public void depositAndNameTestScvFileResource(double amount, String name, BankAcc bankAcc){
        bankAcc.deposit(amount);
        bankAcc.setHolder(name);
        assertEquals(amount, bankAcc.getBalance());
        assertEquals(name, bankAcc.getHolder());
    }



}
