package com.vladproduction.model;

import com.vladproduction.ModelsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

public class OwnersParameterizedTest implements ModelsTest {

    @ParameterizedTest
    @ValueSource(strings = {"Spring", "Java", "vladproduction"})
    public void testValueSource(String value){
        System.out.println(value);
    }

    @DisplayName("Value Source Displayed Name Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ValueSource(strings = {"Docker", "Java", "Git", "SpringBoot", "Maven", "Jenkins"})
    public void testValueSourceDisplayedName(String value){
        System.out.println(value);
    }

    @DisplayName("Enum Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @EnumSource(OwnerType.class)
    public void testEnum(OwnerType ownerType){
        System.out.println(ownerType);
    }

    @DisplayName("Csv Input Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvSource({
            "MU, 1, 1",
            "ARS, 1, 2",
            "CHE, 1, 3"
    })
    public void testCsvInput(String stateName, int val1, int val2){
        System.out.println(stateName + " = " + val1 + " : " + val2);
    }

    @DisplayName("Csv Input File Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvFileSource(resources = "/input.csv", numLinesToSkip = 1)
    public void testCsvInputFile(String club, int val1, String val2, String val3){
        System.out.println(club + " : " + val1 + " , " + val2 + " , " + val3);
    }

    @DisplayName("Method Provider Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @MethodSource("getArgs")
    public void testFromMethodProvider(String club, int val1, String val2, String val3){
        System.out.println(club + " : " + val1 + " , " + val2 + " , " + val3);
    }

    static Stream<Arguments> getArgs(){
        return Stream.of(
                Arguments.of("MU", 1878, "Old Trafford", "England"),
                Arguments.of("RM", 1902, "Estadio Santiago Bernabéu", "Spain"),
                Arguments.of("DK", 1927, "Dynamo Stadium named after Valeriy Lobanovskyi", "Ukraine")
        );
    }


}
