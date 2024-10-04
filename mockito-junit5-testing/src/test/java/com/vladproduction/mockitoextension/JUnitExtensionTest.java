package com.vladproduction.mockitoextension;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * do not need initMocks method in {@BeforeEach} section
 * while we are using {@ExtendWith(MockitoExtension.class)}
 * */
@ExtendWith(MockitoExtension.class)
public class JUnitExtensionTest {

    @Mock
    Map<String, Object> mapMock;
    @Mock
    List<String> stringListMock;
    @Mock
    Iterator<String> iteratorMock;

    /*@BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }*/

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

        // Set up the hasNext() behavior first
        when(iteratorMock.hasNext()).thenReturn(true, true, false);
        when(iteratorMock.next()).thenReturn("One", "Two");

        // First call to hasNext should return true
        assertEquals(true, iteratorMock.hasNext());
        // First call to next should return "One"
        assertEquals("One", iteratorMock.next());

        // Second call to hasNext should return true
        assertEquals(true, iteratorMock.hasNext());
        // Second call to next should return "Two"
        assertEquals("Two", iteratorMock.next());

        // Third call to hasNext should return false
        assertEquals(false, iteratorMock.hasNext());
    }

}
