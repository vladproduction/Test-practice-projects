package org.springframework.samples.petclinic.vp.junit4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.samples.petclinic.vp.YannyWordsProducer;

@Configuration
public class YannyConfig {

    @Bean
    YannyWordsProducer yannyWordsProducer(){
        return new YannyWordsProducer();
    }

}
