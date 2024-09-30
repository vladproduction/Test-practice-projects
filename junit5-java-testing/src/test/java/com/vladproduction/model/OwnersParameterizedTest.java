package com.vladproduction.model;

import com.vladproduction.ModelsTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class OwnersParameterizedTest implements ModelsTest {

    @ParameterizedTest
    @ValueSource(strings = {"Spring", "Java", "vladproduction"})
    public void testValueSource(String value){
        System.out.println(value);
    }

}
