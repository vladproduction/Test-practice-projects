package org.springframework.samples.petclinic.vp;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class LaurelWordsProducer implements WordProducer{

    @Override
    public String getWord() {
        return "Laurel";
    }
}
