package org.example.structures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

    Stackable stack;

    @BeforeEach
    void setUp() {
        stack = new MyStack();
    }

    @Test
    void shouldBeEmpty() {
        boolean isEmpty = stack.isEmpty();

        assertTrue(isEmpty);
    }

    @Test
    void shouldNotBeEmpty() {
        stack.push(2);
        boolean isEmpty = stack.isEmpty();

        assertFalse(isEmpty);
    }

    @Test
    void shouldBeFull() {
        for(int i = 0; i < 8; i++) {
            stack.push(i);
        }

        boolean isFull = stack.isFull();

        assertTrue(isFull);
    }

    @Test
    void shouldPushElement() {
        stack.push(2);

        int element = stack.peek();

        assertEquals(2, element);
    }

    @Test
    void shouldNotPushElementThrowsException() {
        for(int i = 0; i < 8; i++) {
            stack.push(i);
        }

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> stack.push(9));

        assertEquals("Stack is already full", exception.getMessage());
    }

    @Test
    void shouldPopElement() {
        stack.push(2);
        stack.push(3);


        int removedElement = stack.pop();
        int currentElement = stack.peek();

        assertEquals(3, removedElement);
        assertEquals(2, currentElement);
    }

    @Test
    void shouldNotPopElementThrowsException() {

        assertThrows(EmptyStackException.class, () -> stack.pop());
    }

    @Test
    void shouldPeek() {
        stack.push(2);

        int element = stack.peek();

        assertEquals(2, element);
    }

    @Test
    void shouldNotPeekThrowsException() {
        assertThrows(EmptyStackException.class, () -> stack.peek());
    }
}