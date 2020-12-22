package linkedlist;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("## LinkedList 테스트 ##")
class LinkedListImplementTest {

    @Nested
    @DisplayName("add 메소드는")
    class AddTest {

        @Nested
        @DisplayName("올바른 position이 주어졌을 때, ")
        class ValidatePosition {

            @Test
            @DisplayName("추가된 노드를 반환한다.")
            void returnAddNode() {
                LinkedListImplement list = new LinkedListImplement();
                ListNode head = new ListNode(1);
                ListNode node2 = new ListNode(2);
                ListNode node3 = new ListNode(3);
                ListNode node4 = new ListNode(4);

                list.add(head, node2, 1);
                list.add(head, node3, 2);
                list.add(head, node4, 3);
                assertEquals(1, head.getData());
                assertEquals(2, head.getNext().getData());
                assertEquals(3, head.getNext().getNext().getData());
                assertEquals(4, head.getNext().getNext().getNext().getData());

                ListNode newNode = new ListNode(100);
                head = list.add(head, newNode, 0);
                assertEquals(100, head.getData());
            }
        }

        @Nested
        @DisplayName("잘못된 position이 주어졌을 때,")
        class InValidatePosition {

            @Test
            @DisplayName("null을 반환한다.")
            void returnNull() {
                LinkedListImplement list = new LinkedListImplement();
                ListNode head = new ListNode(1);
                ListNode node2 = new ListNode(2);

                assertNull(list.add(head, node2, 2));
            }
        }
    }


    @Nested
    @DisplayName("remove 메소드는")
    class RemoveTest {

        @Nested
        @DisplayName("올바른 position이 주어졌을 때,")
        class ValidatePosition {
            @DisplayName("해당 위치의 노드를 삭제 후, head를 반환한다.")
            @Test
            public void returnRemoveNode() {
                LinkedListImplement list = new LinkedListImplement();

                ListNode head = new ListNode(1);
                ListNode node2 = new ListNode(2);
                ListNode node3 = new ListNode(3);

                list.add(head, node2, 1);
                list.add(head, node3, 2);

                head = list.remove(head, 0);
                assertEquals(head, node2);
                head = list.remove(head, 0);
                assertEquals(head, node3);
            }
        }

        @Nested
        @DisplayName("잘못된 position이 주어졌을 때,")
        class InValidatePostion {
            @DisplayName("null을 반환한다.")
            @Test
            public void returnNull() {
                LinkedListImplement list = new LinkedListImplement();

                ListNode head = new ListNode(1);
                ListNode node2 = new ListNode(2);

                head = list.remove(head, 2);
                assertNull(head);
            }
        }
    }

    @Nested
    @DisplayName("contains 메소드는")
    class ContainTest {

        @Nested
        @DisplayName("check 노드가 존재할 때,")
        class hasCheckNode {
            @DisplayName("true를 반환한다.")
            @Test
            public void returnTrue() {
                LinkedListImplement list = new LinkedListImplement();

                ListNode head = new ListNode(1);
                ListNode node2 = new ListNode(2);

                list.add(head, node2, 1);

                assertTrue(list.contains(head, head));
                assertTrue(list.contains(head, node2));
            }
        }

        @Nested
        @DisplayName("check 노드가 존재하지 않을 때,")
        class NoHasCheckNode {
            @DisplayName("false를 반환한다.")
            @Test
            public void returnFalse() {
                LinkedListImplement list = new LinkedListImplement();

                ListNode head = new ListNode(1);
                ListNode node2 = new ListNode(2);

                assertFalse(list.contains(head, node2));
            }
        }
    }
}