package com.vladproduction.inlinemock;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * inline mocks with different data structures and methods,
 * showing how to set up behavior, verify interactions, and handle multiple return values
 * */
public class InlineMockTest {

    interface MyService {
        String getData();
    }

    interface UserRepository {
        void save(String user);
    }

    @Test
    public void testInlineMockMap() {
        Map mapMock = mock(Map.class);
        assertEquals(mapMock.size(), 0);
    }

    @Test
    public void testInlineMockList() {
        List<String> listMock = mock(List.class);
        when(listMock.size()).thenReturn(5); // Specify what size should return
        assertEquals(5, listMock.size());
    }

    @Test
    public void testInlineMockService(){
        MyService serviceMock = mock(MyService.class);
        when(serviceMock.getData()).thenReturn("Mock Data from MyService");
        assertEquals("Mock Data from MyService", serviceMock.getData());
    }

    @Test
    void testInlineMockVerify() {
        UserRepository userRepositoryMock = mock(UserRepository.class);

        userRepositoryMock.save("John Doe");

        // Verify that save was called with "John Doe" exactly once
        verify(userRepositoryMock, times(1)).save("John Doe");
    }

    @Test
    void testInlineMockIterator() {
        Iterator<String> iteratorMock = mock(Iterator.class);
        when(iteratorMock.hasNext()).thenReturn(true, true, false); // First hasNext returns true twice, then false
        when(iteratorMock.next()).thenReturn("First", "Second");

        assertEquals("First", iteratorMock.next());
        assertEquals("Second", iteratorMock.next());
        assertEquals(true, iteratorMock.hasNext());
        assertEquals(true, iteratorMock.hasNext());
        assertEquals(false, iteratorMock.hasNext());
    }
}
