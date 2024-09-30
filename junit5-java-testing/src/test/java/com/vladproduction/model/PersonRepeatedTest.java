package com.vladproduction.model;

import com.vladproduction.ModelRepeatedTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class PersonRepeatedTest implements ModelRepeatedTest {

    @DisplayName("My Assignment Repeated Test")
    @RepeatedTest(value = 5, name = "{displayName} : {currentRepetition} | {totalRepetitions}")
    public void testAssignmentRepeated() {
        //
    }


}
