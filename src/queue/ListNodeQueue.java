package queue;

import linkedlist.ListNode;

public class ListNodeQueue implements Queue{

    private ListNode head;
    private ListNode tail;
    private ListNode que;
    private int size = 0;

    @Override
    public boolean add(int data) {
        if (isEmpty()) {
            que = new ListNode(data);
            head = tail = que;
        } else {
            ListNode newNode = new ListNode(data);
            tail.next = newNode;
            newNode.pre = tail;
            tail = newNode;
        }
        size++;
        return true;
    }

    @Override
    public int poll() {
        if (isEmpty()) throw new IndexOutOfBoundsException();
        int data = head.getData();
        head = head.next;
        size--;
        return data;
    }

    @Override
    public int peek() {
        if (isEmpty()) throw new IndexOutOfBoundsException();
        return head.getData();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode cur = head;
        while (cur != null) {
            sb.append(cur.getData());
            if (cur != tail) sb.append(",");
            cur = cur.next;
        }
        return sb.toString();
    }

}
