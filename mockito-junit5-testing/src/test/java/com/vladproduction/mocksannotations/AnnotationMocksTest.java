package com.vladproduction.mocksannotations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class AnnotationMocksTest {

    @Mock
    Map<String, Object> mapMock;
    @Mock
    List<String> stringListMock;
    @Mock
    Iterator<String> iteratorMock;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMock() {
        mapMock.put("key", "value");
    }

    @Test
    void testListMock() {
        when(stringListMock.size()).thenReturn(3);
        when(stringListMock.get(0)).thenReturn("First");

        assertEquals(3, stringListMock.size());
        assertEquals("First", stringListMock.get(0));
    }

    @Test
    void testIteratorMock() {
        when(iteratorMock.hasNext()).thenReturn(true, true, false);
        when(iteratorMock.next()).thenReturn("One", "Two");

        assertEquals("One", iteratorMock.next());
        assertEquals("Two", iteratorMock.next());
        assertEquals(false, iteratorMock.hasNext());
    }
}
