package stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack implements Stack {

    private static final int DEFAULT_CAPACITY = 1;
    private int size = 0;
    private int[] stack;

    public ArrayStack() {
        this.stack = new int[DEFAULT_CAPACITY];
    }

    @Override
    public void push(int data) {
        if (isFull()) expendStack(size * 2);
        stack[size] = data;
        size++;
    }

    public void expendStack(int size) {
        stack = Arrays.copyOf(stack, size);
    }

    public boolean isFull() {
        return size == stack.length;
    }

    @Override
    public int pop() {
        if (isEmpty()) throw new EmptyStackException();
        int data = stack[--size];
        stack[size] = 0;
        return data;
    }

    public int peek() {
        return stack[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getStackSize() {
        return size;
    }
}