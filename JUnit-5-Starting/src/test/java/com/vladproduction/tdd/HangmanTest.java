package com.vladproduction.tdd;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class HangmanTest {

    @Test
    public void testCountCharsInWord(){
        String word = "pizza";
        char symbol = 'z';
        Hangman hangman = new Hangman();
        int count = hangman.countCountCharsInWord(word, symbol);
        assertEquals(2, count);
    }

    @Test
    public void testLengthOfFetchedWord(){
        Hangman hangman = new Hangman();
        String word = hangman.fetchedWord();
        assertTrue(word.length() == 5);
    }

    @Test
    public void testLengthOfFetchedWordRandom(){
        Random random = new Random();
        int requestedWordLength = random.nextInt(6) + 5; //from 5 to 10
        Hangman hangman = new Hangman();
        hangman.loadWords();
        String word = hangman.fetchedWord(requestedWordLength);
        assertTrue(requestedWordLength == word.length());
    }

    @Test
    public void testUniquenessOfFetchedWord(){
        Random random = new Random();
        int requestedLength = 0;
        Set<String> usedWordsSet = new HashSet<>();
        int round = 0;
        String word = null;
        Hangman hangman = new Hangman();
        hangman.loadWords();

        // Define max rounds based on unique words availability
        int maxUniqueWords = 5; // Known unique words from the file based on your provided content

        while (round < 100 && usedWordsSet.size() < maxUniqueWords){
            requestedLength = random.nextInt(6) + 5; // Generates lengths from 5 to 10
            word = hangman.fetchedWord(requestedLength);

            if (word != null) { // Check if the word is not null
                assertTrue(usedWordsSet.add(word)); // Only add if it is not already in the set
                round++;
            }
        }

        // Assert that we have fetched the maximum number of unique words
        assertEquals(maxUniqueWords, usedWordsSet.size());
    }

    @Test
    public void testUniquenessOfFetchedWordsLength5To10(){
        Random random = new Random();
        int requestedLength;
        Set<String> usedWordsSet = new HashSet<>();
        int round = 0;
        String word;
        Hangman hangman = new Hangman();

        // Get the number of unique words available for lengths 5 to 10
        int maxUniqueWords = countUniqueWordsInFile(5, 10);

        while (round < 100 && usedWordsSet.size() < maxUniqueWords) {
            requestedLength = random.nextInt(6) + 5; // Generates lengths from 5 to 10
            word = hangman.fetchedWord(requestedLength);

            if (word != null) { // Check if the word is not null
                assertTrue(usedWordsSet.add(word)); // Only add if it is not already in the set
                round++;
            }
        }

        // Assert that we have fetched the maximum number of unique words
        assertEquals(maxUniqueWords, usedWordsSet.size());
    }

    // Helper static method to count unique words in the file within the specified length range
    private static int countUniqueWordsInFile(int minLength, int maxLength) {
        Set<String> wordsSet = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader("word_source.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                int length = line.length();
                if (length >= minLength && length <= maxLength) {
                    wordsSet.add(line); // Collect unique words within the length range
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle I/O exceptions
        }
        return wordsSet.size(); // Return the count of unique words
    }

}
