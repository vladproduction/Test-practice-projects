package com.vladproduction.studentparametersscore;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentStatScoreParamsTest {

    @ParameterizedTest
    @MethodSource("testScoresValues")
    public void parameterizedStudentScoreTests(int mathScore, int literacyScore, int expectedResult) {
        StudentStatScore sc = new StudentStatScore();
        sc.calculateScore(mathScore, literacyScore);
        assertEquals(expectedResult, sc.getScore());
    }

    //same stuff with using sources from csv file:
    @ParameterizedTest
    @CsvFileSource(resources = "/scores.csv", delimiter = ';')
    public void parameterizedStudentScoreFromCscTests(int mathScore, int literacyScore, int expectedResult) {
        StudentStatScore sc = new StudentStatScore();
        sc.calculateScore(mathScore, literacyScore);
        assertEquals(expectedResult, sc.getScore());
    }

    private static Object[] testScoresValues() {

        return new Object[]{
                new Object[]{50, 50, 2500},
                new Object[]{-10, 50, -1},
                new Object[]{50, -5, -1},
                new Object[]{-50, -5, -1},
                new Object[]{150, 50, -1},
                new Object[]{50, 150, -1},
                new Object[]{150, 150, -1},
                new Object[]{150, -150, -1},
                new Object[]{-150, 150, -1},
                new Object[]{100, 100, 10000},
                new Object[]{0, 0, 0},
        };

    }

}
