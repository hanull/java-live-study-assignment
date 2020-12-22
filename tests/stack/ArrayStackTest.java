package stack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("ArrayStack 테스트")
class ArrayStackTest {

    @Nested
    @DisplayName("push 메소드는")
    class Push {

        @Nested
        @DisplayName("스택이 꽉 찼을 때,")
        class NoRoomStack {
            @Test
            @DisplayName("스택 공간을 2배 확장하고, 데이터를 push한다.")
            public void expandArrayAndAddData() {
                ArrayStack stack = new ArrayStack();

                stack.push(1);
                assertTrue(stack.isFull());

                stack.push(2);
                assertEquals(2, stack.getStackSize());
            }
        }

        @Nested
        @DisplayName("스택에 여유 공간이 있을 때,")
        class HasRoomStack {
            @Test
            @DisplayName("데이터만 stack에 push한다.")
            public void addData() {
                ArrayStack stack = new ArrayStack();

                stack.push(1);
                assertEquals(1, stack.getStackSize());
                assertEquals(1, stack.peek());
            }
        }
    }

    @Nested
    @DisplayName("pop 메소드는")
    class Pop {

        @Nested
        @DisplayName("스택이 비었을 때,")
        class EmptyStack {
            @DisplayName("예외를 발생시킨다.")
            @Test
            public void throwException() {
                ArrayStack stack = new ArrayStack();

                stack.push(1);
                stack.pop();
                assertThrows(EmptyStackException.class, () -> stack.pop());
            }
        }

        @Nested
        @DisplayName("스택에 데이터가 있을 때,")
        class HasData {
            @DisplayName("가장 위에 있는 데이터를 반환한다.")
            @Test
            public void popData() {
                ArrayStack stack = new ArrayStack();

                stack.push(1);
                stack.push(2);
                int data = stack.pop();

                assertEquals(data, 2);
                assertEquals(stack.peek(), 1);
            }
        }
    }
}
