package org.springframework.samples.petclinic.vp.junit5;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.vp.Interpreter;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(classes = {BaseConfig5.class, LaurelConfig5.class})
class InterpreterLaurelTest {

    @Autowired
    Interpreter interpreter;

    @Test
    void whatIHear() {
        String word = interpreter.whatIHear();
        assertEquals("Laurel", word);
    }
}