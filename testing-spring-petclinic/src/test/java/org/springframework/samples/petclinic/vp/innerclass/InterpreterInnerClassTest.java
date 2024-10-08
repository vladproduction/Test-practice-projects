package org.springframework.samples.petclinic.vp.innerclass;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.samples.petclinic.vp.Interpreter;
import org.springframework.samples.petclinic.vp.LaurelWordsProducer;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(classes = InterpreterInnerClassTest.TestConfig.class)
class InterpreterInnerClassTest {

    @Configuration
    static class TestConfig{
        @Bean
        Interpreter interpreter(){
            return new Interpreter(new LaurelWordsProducer());
        }
    }

    @Autowired
    Interpreter interpreter;

    @Test
    void whatIHear() {
        String word = interpreter.whatIHear();
        assertEquals("Laurel", word);
    }
}