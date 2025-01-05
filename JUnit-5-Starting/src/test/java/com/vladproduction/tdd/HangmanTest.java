package com.vladproduction.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HangmanTest {

    @Test
    public void testCountCharsInWord(){
        String word = "pizza";
        char symbol = 'z';
        Hangman hangman = new Hangman();
        int count = hangman.countCountCharsInWord(word, symbol);
        assertEquals(2, count);
    }

}
