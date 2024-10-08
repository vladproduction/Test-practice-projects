package org.springframework.samples.petclinic.vp.junit4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.samples.petclinic.vp.Interpreter;
import org.springframework.samples.petclinic.vp.WordProducer;

@Profile("base-test4")
@Configuration
public class BaseConfig4 {

    @Bean
    Interpreter interpreter(WordProducer wordProducer){

        return new Interpreter(wordProducer);
    }

}