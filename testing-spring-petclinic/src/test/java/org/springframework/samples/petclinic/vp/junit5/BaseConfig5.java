package org.springframework.samples.petclinic.vp.junit5;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.samples.petclinic.vp.Interpreter;
import org.springframework.samples.petclinic.vp.WordProducer;

@Configuration
public class BaseConfig5 {

    @Bean
    Interpreter interpreter(@Qualifier("laurelWordsProducer") WordProducer wordProducer){

        return new Interpreter(wordProducer);
    }

}
