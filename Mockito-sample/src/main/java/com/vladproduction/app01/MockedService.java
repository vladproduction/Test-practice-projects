package com.vladproduction.app01;

import org.springframework.stereotype.Service;

@Service
public class MockedService {

    public Integer math(Integer a, Integer b){

        return a + b;
    }
}
