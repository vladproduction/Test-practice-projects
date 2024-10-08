package org.springframework.samples.petclinic.vp.junit4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.samples.petclinic.vp.LaurelWordsProducer;

@Configuration
public class LaurelConfig {

    @Bean
    LaurelWordsProducer laurelWordsProducer(){
        return new LaurelWordsProducer();
    }

}
