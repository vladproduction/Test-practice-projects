package org.springframework.samples.petclinic.vp.junit5;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.samples.petclinic.vp.Interpreter;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringJUnitConfig(classes = InterpreterComponentScanTest.TestComponentConfig.class)
public class InterpreterComponentScanTest {

    @Configuration
    @ComponentScan("org.springframework.samples.petclinic.vp")
    static class TestComponentConfig{

    }
    @Autowired
    Interpreter interpreter;

    @Test
    public void whatIHear() {
        String word = interpreter.whatIHear();
        assertEquals("Laurel", word);
    }
}