package org.springframework.samples.petclinic.vp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LaurelConfig {

    @Bean
    LaurelWordsProducer laurelWordsProducer(){
        return new LaurelWordsProducer();
    }

}
