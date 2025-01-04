package com.vladproduction.studentparametersscore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class StudentStatScoreBeforeCaseTest {

    private StudentStatScore sc;

    @BeforeEach
    void setUp() {
        sc = new StudentStatScore();
    }

    @Test
    @DisplayName("regular case")
    public void studentScoreRegularTest(){

        sc.calculateScore(50, 50);
        assertEquals(2500, sc.getScore());
    }

    @Test
    @DisplayName("math negative")
    public void studentScoreMathNegativeTest(){
        sc.calculateScore(-7, 50);
        assertEquals(-1, sc.getScore());
    }

    @Test
    @DisplayName("literacy negative")
    public void studentScoreLiteracyNegativeTest(){
        sc.calculateScore(50, -7);
        assertEquals(-1, sc.getScore());
    }

    @Test
    @DisplayName("math high")
    public void studentScoreMathHighTest(){
        sc.calculateScore(150, 50);
        assertEquals(-1, sc.getScore());
    }

    @Test
    @DisplayName("literacy high")
    public void studentScoreLiteracyHighTest(){
        sc.calculateScore(50, 150);
        assertEquals(-1, sc.getScore());
    }

    @Test
    @DisplayName("both high")
    public void studentScoreMathAndLiteracyHighTest(){
        sc.calculateScore(150, 150);
        assertEquals(-1, sc.getScore());
    }

    @Test
    @DisplayName("both negative")
    public void studentScoreMathAndLiteracyNegativeTest(){
        sc.calculateScore(-150, -150);
        assertEquals(-1, sc.getScore());
    }


}