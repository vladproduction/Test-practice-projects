package com.vladproduction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;

@Tag("model")
public interface ModelsTest {

    @BeforeEach
    default void beforeEachConsoleOutput(TestInfo testInfo){
        System.out.println("Running Test - " +
                testInfo.getDisplayName());
    }
}
