package com.vladproduction.tdd;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Hangman {

    Set<String> usedWordsSet = new HashSet<>();
    List<String> wordslist = new ArrayList<>();

    public int countCountCharsInWord(String word, char symbol) {
        int result = 0;
        for (char c: word.toCharArray()) {
            if(symbol == c){
                result++;
            }
        }
        return result;
    }

    public String fetchedWord() {
        String word = "pizza";
        return word;
    }

    public String fetchedWord(int requestedWordLength) {
        String result = null;
        try(BufferedReader br = new BufferedReader(new FileReader("word_source.txt"))){
            while ((result = br.readLine()) != null){
                if(result.length() != requestedWordLength){
                    continue;
                } else if (usedWordsSet.add(result)) {
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    //add to refactoring code:
    public void loadWords(){
        String word = null;
        try(BufferedReader br = new BufferedReader(new FileReader("word_source.txt"))){
            while ((word = br.readLine()) != null){
                wordslist.add(word);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //refactoring fetchWord method as well:
    public String fetchedWordRefactored(int requestedWordLength) {
        for (String word : wordslist) {
            if(word.length() != requestedWordLength){
                continue;
            } else if (usedWordsSet.add(word)) {
                return word;
            }
        }
        return null;
    }


}
