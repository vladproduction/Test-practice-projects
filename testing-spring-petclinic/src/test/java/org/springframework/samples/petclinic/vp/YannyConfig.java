package org.springframework.samples.petclinic.vp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class YannyConfig {

    @Bean
    YannyWordsProducer yannyWordsProducer(){
        return new YannyWordsProducer();
    }

}
