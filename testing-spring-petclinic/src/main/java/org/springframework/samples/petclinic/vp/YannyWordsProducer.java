package org.springframework.samples.petclinic.vp;

import org.springframework.stereotype.Component;

@Component
public class YannyWordsProducer implements WordProducer{

    @Override
    public String getWord() {
        return "Yanny";
    }
}
