package org.springframework.samples.petclinic.vp.junit5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.samples.petclinic.vp.YannyWordsProducer;

@Profile("base-test")
@Configuration
public class YannyConfig5 {

    @Bean
    YannyWordsProducer yannyWordsProducer(){

        return new YannyWordsProducer();
    }

}
