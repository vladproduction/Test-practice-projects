package org.springframework.samples.petclinic.vp.junit5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.samples.petclinic.vp.Interpreter;
import org.springframework.samples.petclinic.vp.WordProducer;

@Configuration
public class BaseConfig {

    @Bean
    Interpreter interpreter(WordProducer wordProducer){
        return new Interpreter(wordProducer);
    }

}
