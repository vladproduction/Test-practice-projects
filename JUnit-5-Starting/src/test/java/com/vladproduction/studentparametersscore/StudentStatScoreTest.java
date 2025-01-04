package com.vladproduction.studentparametersscore;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class StudentStatScoreTest {

    @Test
    @DisplayName("regular case")
    public void studentScoreRegularTest(){
        StudentStatScore sc = new StudentStatScore();
        sc.calculateScore(50, 50);
        assertEquals(2500, sc.getScore());
    }

    @Test
    @DisplayName("math negative")
    public void studentScoreMathNegativeTest(){
        StudentStatScore sc = new StudentStatScore();
        sc.calculateScore(-7, 50);
        assertEquals(-1, sc.getScore());
    }

    @Test
    @DisplayName("literacy negative")
    public void studentScoreLiteracyNegativeTest(){
        StudentStatScore sc = new StudentStatScore();
        sc.calculateScore(50, -7);
        assertEquals(-1, sc.getScore());
    }

    @Test
    @DisplayName("math high")
    public void studentScoreMathHighTest(){
        StudentStatScore sc = new StudentStatScore();
        sc.calculateScore(150, 50);
        assertEquals(-1, sc.getScore());
    }

    @Test
    @DisplayName("literacy high")
    public void studentScoreLiteracyHighTest(){
        StudentStatScore sc = new StudentStatScore();
        sc.calculateScore(50, 150);
        assertEquals(-1, sc.getScore());
    }

    @Test
    @DisplayName("both high")
    public void studentScoreMathAndLiteracyHighTest(){
        StudentStatScore sc = new StudentStatScore();
        sc.calculateScore(150, 150);
        assertEquals(-1, sc.getScore());
    }

    @Test
    @DisplayName("both negative")
    public void studentScoreMathAndLiteracyNegativeTest(){
        StudentStatScore sc = new StudentStatScore();
        sc.calculateScore(-150, -150);
        assertEquals(-1, sc.getScore());
    }


}