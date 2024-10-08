package org.springframework.samples.petclinic.vp.junit5;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.vp.Interpreter;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(classes = {BaseConfig.class, YannyConfig.class})
class InterpreterYannyTest {

    @Autowired
    Interpreter interpreter;
    @Test
    void whatIHear() {
        String word = interpreter.whatIHear();
        assertEquals("Yanny", word);
    }
}