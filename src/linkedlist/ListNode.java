package linkedlist;

public class ListNode {
    private int data;
    public ListNode next;
    public ListNode pre;

    public ListNode(int data) {
        this.data = data;
        next = null;
        pre = null;
    }

    public int getData() {
        return this.data;
    }

    public ListNode getNext() {
        return this.next;
    }
}
