package stack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("ListNodeStack 테스트")
class ListNodeStackTest {

    @Nested
    @DisplayName("push 메소드는")
    class Push {

        @Test
        @DisplayName("데이터를 push한다.")
        public void push() {
            ListNodeStack stack = new ListNodeStack();

            stack.push(1);
            stack.push(2);
            assertEquals(2, stack.getSize());
            assertEquals(2, stack.peek());
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
                ListNodeStack stack = new ListNodeStack();

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
                ListNodeStack stack = new ListNodeStack();

                stack.push(1);
                stack.push(2);
                int data = stack.pop();

                assertEquals(data, 2);
                assertEquals(stack.peek(), 1);
            }
        }
    }
}