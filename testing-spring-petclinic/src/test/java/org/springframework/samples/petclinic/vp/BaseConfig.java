package org.springframework.samples.petclinic.vp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseConfig {

    @Bean
    Interpreter interpreter(WordProducer wordProducer){
        return new Interpreter(wordProducer);
    }

}
