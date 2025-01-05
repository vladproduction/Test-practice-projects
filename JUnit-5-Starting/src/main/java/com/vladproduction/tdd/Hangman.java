package com.vladproduction.tdd;

public class Hangman {
    public int countCountCharsInWord(String word, char symbol) {

        int result = 0;
        for (char c: word.toCharArray()) {
            if(symbol == c){
                result++;
            }
        }
        return result;

    }
}
