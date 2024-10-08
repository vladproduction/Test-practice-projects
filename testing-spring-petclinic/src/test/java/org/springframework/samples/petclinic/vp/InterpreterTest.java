package org.springframework.samples.petclinic.vp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

public class InterpreterTest {

    Interpreter interpreter;

    @Before
    public void setUp() throws Exception {
//        interpreter = new Interpreter(new LaurelWordsProducer());
        interpreter = new Interpreter(new YannyWordsProducer());
    }

    @Test
    public void whatIHearTest() {
        String word = interpreter.whatIHear();
//        assertEquals("Laurel", word);
        assertEquals("Yanny", word);
    }
}