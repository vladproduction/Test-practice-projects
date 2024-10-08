package org.springframework.samples.petclinic.vp;

import org.springframework.stereotype.Service;

@Service
public class Interpreter {

    private final WordProducer wordProducer;

    public Interpreter(WordProducer wordProducer) {
        this.wordProducer = wordProducer;
    }

    public String whatIHear(){
        String word = wordProducer.getWord();
        System.out.println(word);
        return word;
    }

}
