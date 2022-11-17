package org.example.structures;

import java.util.EmptyStackException;

public class MyStack implements Stackable{
    private final int[] stack;
    private int top;

    public MyStack(int capacity) {
        stack = new int[capacity];
        top = -1;
    }

    public MyStack() {
        this(8);
    }


    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == stack.length - 1;
    }

    @Override
    public void push(int element) {
        if(isFull()) throw new IllegalArgumentException("Stack is already full");
        stack[++top] = element;
    }

    @Override
    public int pop() {
        if(isEmpty()) throw new EmptyStackException();
        return stack[top--];
    }

    @Override
    public int peek() {
        if(isEmpty()) throw new EmptyStackException();
        return stack[top];
    }


}
