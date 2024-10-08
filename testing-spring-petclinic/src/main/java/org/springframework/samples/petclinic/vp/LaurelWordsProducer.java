package org.springframework.samples.petclinic.vp;

import org.springframework.stereotype.Component;

@Component
public class LaurelWordsProducer implements WordProducer{

    @Override
    public String getWord() {
        return "Laurel";
    }
}
