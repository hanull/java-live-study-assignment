package linkedlist;

public class LinkedListImplement implements LinkedList {

    @Override
    public ListNode add(ListNode head, ListNode nodeToAdd, int position) {
        if (!isValidateRange(head, position)) return null;
        if (position == 0) {
            nodeToAdd.next = head;
            head.pre = nodeToAdd;
        } else {
            ListNode curNode = head;
            int idx = 0;
            while (idx < position - 1) {
                curNode = curNode.next;
                idx++;
            }
            nodeToAdd.next = curNode.next;
            curNode.next = nodeToAdd;
        }
        return nodeToAdd;
    }

    @Override
    public ListNode remove(ListNode head, int positionToRemove) {
        if (!isValidateRange(head, positionToRemove)) return null;
        ListNode headNode = head;
        if (positionToRemove == 0) {
            head.next.pre = null;
            headNode = head.next;
        } else {
            ListNode curNode = head;
            int idx = 0;
            while (idx < positionToRemove) {
                curNode = curNode.next;
                idx++;
            }
            curNode.pre.next = curNode.next;
            curNode.next.pre = curNode.pre;
        }
        return headNode;
    }

    @Override
    public boolean contains(ListNode head, ListNode nodeTocheck) {
        if (head == null) return false;
        while (head != null) {
            if (head == nodeTocheck) return true;
            head = head.next;
        }
        return false;
    }

    public boolean isValidateRange(ListNode head, int position) {
        int size = getSize(head);
        return position < 0 || position > size ? false : true;
    }

    public int getSize(ListNode head) {
        if (head == null) return 0;
        int res = 0;
        while (head != null) {
            head = head.next;
            res++;
        }
        return res;
    }

}
