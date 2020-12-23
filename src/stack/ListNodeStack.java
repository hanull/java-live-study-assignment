package stack;

import linkedlist.ListNode;

import java.util.EmptyStackException;

public class ListNodeStack implements Stack {

    private ListNode stack;
    private ListNode head;
    private int size = 0;

    @Override
    public void push(int data) {
        if (isEmpty()) {
            stack = new ListNode(data);
            head = stack;
        } else {
            ListNode newNode = new ListNode(data);
            newNode.pre = head;
            head.next = newNode;
            head = newNode;
        }
        size++;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int pop() {
        if (isEmpty()) throw new EmptyStackException();
        int data = head.getData();
        head = head.pre;
        size--;
        return data;
    }

    public int peek() {
        if (isEmpty()) throw new EmptyStackException();
        return head.getData();
    }

    public int getSize() {
        return size;
    }
}
