package queue;

import java.util.Arrays;

public class ArrayQueue implements Queue {

    private static final int DEFAULT_CAPACITY = 1;
    private int current_capacity;
    private int len;
    private int[] arrQueue;

    public ArrayQueue() {
        this.current_capacity = 1;
        this.len = 0;
        this.arrQueue = new int[DEFAULT_CAPACITY];
    }

    @Override
    public boolean add(int data) {
        if (isFull()) expandQueue(current_capacity * 2);
        arrQueue[len] = data;
        len++;
        return true;
    }

    @Override
    public int poll() {
        if (isEmpty()) throw new IndexOutOfBoundsException();
        int data = arrQueue[0];
        relocate();
        len--;
        return data;
    }

    public void relocate() {
        for (int i = 1; i < len; i++) {
            arrQueue[i - 1] = arrQueue[i];
            arrQueue[i] = 0;
        }
    }

    @Override
    public int peek() {
        if (isEmpty()) throw new IndexOutOfBoundsException();
        return arrQueue[0];
    }

    public void expandQueue(int size) {
        arrQueue = Arrays.copyOf(arrQueue, size);
        current_capacity = size;
    }

    public boolean isEmpty() {
        return len == 0;
    }

    public boolean isFull() {
        return len == current_capacity;
    }

    public int getCapacity() {
        return current_capacity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(arrQueue[i]);
            if (i < len-1) sb.append(",");
        }
        return sb.toString();
    }

}
