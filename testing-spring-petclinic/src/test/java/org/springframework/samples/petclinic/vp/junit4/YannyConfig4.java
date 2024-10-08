package org.springframework.samples.petclinic.vp.junit4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.samples.petclinic.vp.YannyWordsProducer;

@Profile("base-test4")
@Configuration
public class YannyConfig4 {

    @Bean
    YannyWordsProducer yannyWordsProducer(){
        return new YannyWordsProducer();
    }

}
