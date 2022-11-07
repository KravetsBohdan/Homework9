package org.example.structures;

public interface Stackable {

    boolean isEmpty();

    boolean isFull();

    void push(int element);

    int pop();

    int peek();
}
