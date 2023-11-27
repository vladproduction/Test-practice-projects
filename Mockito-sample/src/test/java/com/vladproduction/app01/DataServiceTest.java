package com.vladproduction.app01;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class DataServiceTest {

    private MockedService mockedService = Mockito.mock(MockedService.class); //have to mock our class(that we testing)

    @Test
    public void test(){
        when(mockedService.math(5, 5)).thenReturn(10); //expected behaviour (simulating business logic)

        //create DataService with mockedService
        DataService dataService = new DataService(mockedService);
        Integer resultDataByMock = dataService.calculation(5, 5);

        //testing statement
        assertEquals(20, resultDataByMock);
    }

}