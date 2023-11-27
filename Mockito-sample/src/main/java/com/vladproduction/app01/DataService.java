package com.vladproduction.app01;

import org.springframework.stereotype.Service;

@Service
public class DataService {

    private final MockedService mockedService;

    public DataService(MockedService mockedService) { //injected through constructor
        this.mockedService = mockedService;
    }

    public Integer calculation(Integer a, Integer b){
        Integer result = mockedService.math(a, b);
        result += 10; //we have to test this logic

        return result;
    }
}
