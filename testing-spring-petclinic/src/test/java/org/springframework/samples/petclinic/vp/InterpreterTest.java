package org.springframework.samples.petclinic.vp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {BaseConfig.class, YannyConfig.class})
public class InterpreterTest {

    @Autowired
    Interpreter interpreter;

    /*@Before
    public void setUp() throws Exception {
//        interpreter = new Interpreter(new LaurelWordsProducer());
        interpreter = new Interpreter(new YannyWordsProducer());
    }*/

    @Test
    public void whatIHearTest() {
        String word = interpreter.whatIHear();
//        assertEquals("Laurel", word); //bring that context: marked as Primary
        assertEquals("Yanny", word);
    }
}