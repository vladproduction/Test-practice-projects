package com.vladproduction.model;

import com.vladproduction.ModelsTest;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

//@Tag("model")
public class PersonTest implements ModelsTest {

    @Test
    public void testGroupedAssertions() {
        //given
        Person person = new Person(1L, "John", "Doe");

        //for assertEquals: 'expected', 'actual'
        //when
        assertAll("Test properties Set",
                ()->assertEquals("John", person.getFirstName()),
                ()->assertEquals("Doe", person.getLastName()));
    }

    @Test
    public void testGroupedAssertionsMessaging() {
        //given
        Person person = new Person(1L, "John", "Doe");

        //when
        assertAll("Test properties Set and messaging",
                ()->assertEquals("John", person.getFirstName(), "First Name is not correct"),
                ()->assertEquals("Doe", person.getLastName(), "Last Name is not correct"));
    }

    @DisplayName("My Repeated Test")
    @RepeatedTest(value = 5, name = "{displayName} : {currentRepetition} - {totalRepetitions}")
    public void testRepeatedTest() {
        //just some testing logic:
        Person person = new Person(1L, "John", "Doe");
        assertEquals("John", person.getFirstName(), "First Name is not correct");
    }

    @DisplayName("My Repeated Test With DI")
    @RepeatedTest(value = 5)
    public void testRepeatedTestWithDI(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        //params from test case is injected during runtime:
        System.out.println(testInfo.getDisplayName() + " : " + repetitionInfo.getCurrentRepetition());
    }
}