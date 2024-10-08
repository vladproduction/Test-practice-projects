package org.springframework.samples.petclinic.vp.junit5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.samples.petclinic.vp.LaurelWordsProducer;

@Profile("base-test")
@Configuration
public class LaurelConfig5 {

    @Bean
    LaurelWordsProducer laurelWordsProducer(){

        return new LaurelWordsProducer();
    }

}
