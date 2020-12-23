package queue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("ListNodeQueue 테스트")
class ListNodeQueueTest {

    @Nested
    @DisplayName("add 메소드는")
    class AddMethod {
        @Test
        @DisplayName("데이터를 추가하고 true를 반환한다.")
        void add() {
            ListNodeQueue q = new ListNodeQueue();
            assertTrue(q.add(1));
        }
    }

    @Nested
    @DisplayName("poll 메소드는")
    class PollMethod {

        @Nested
        @DisplayName("큐에 데이터가 없을 때,")
        class NoData {
            @Test
            @DisplayName("예외를 발생시킨다.")
            void throwException() {
                ListNodeQueue q = new ListNodeQueue();

                assertThrows(IndexOutOfBoundsException.class, () -> q.poll());
            }
        }

        @Nested
        @DisplayName("큐에 데이터가 있을 때,")
        class HasData {
            @Test
            @DisplayName("가장 먼저 들어간 데이터를 반환한다.")
            void poll() {
                ListNodeQueue q = new ListNodeQueue();

                q.add(1);
                q.add(2);
                q.add(3);

                assertEquals(1, q.poll());
                assertEquals("2,3", q.toString());
            }
        }
    }
}