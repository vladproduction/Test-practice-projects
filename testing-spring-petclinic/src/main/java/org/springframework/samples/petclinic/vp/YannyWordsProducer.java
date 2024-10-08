package org.springframework.samples.petclinic.vp;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("yanny")
@Primary
@Component
public class YannyWordsProducer implements WordProducer{

    @Override
    public String getWord() {
        return "Yanny";
    }
}
