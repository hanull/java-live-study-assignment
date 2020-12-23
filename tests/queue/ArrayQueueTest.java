package queue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


@DisplayName("ArrayQue 테스트")
class ArrayQueueTest {

    @Nested
    @DisplayName("add 메소드는")
    class AddMethod {

        @Nested
        @DisplayName("큐가 꽉찼을 때,")
        class NoHasRoom {
            @Test
            @DisplayName("공간을 2배 확장하고 데이터를 추가한 뒤, true를 반환한다.")
            void expandAndAdd() {
                ArrayQueue q = new ArrayQueue();

                q.add(1);
                assertEquals(1, q.getCapacity());
                q.add(2);
                assertEquals(2, q.getCapacity());
                assertTrue(q.add(3));
            }

        }

        @Nested
        @DisplayName("큐에 빈 공간이 있을 때,")
        class HasRoom {
            @Test
            @DisplayName("데이터를 추가하고 true를 반환한다.")
            void add() {
                ArrayQueue q = new ArrayQueue();
                assertTrue(q.add(1));
            }
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
                ArrayQueue q = new ArrayQueue();

                assertThrows(IndexOutOfBoundsException.class, () -> q.poll());
            }
        }

        @Nested
        @DisplayName("큐에 데이터가 있을 때,")
        class HasData {
            @Test
            @DisplayName("0번 인덱스의 데이터를 반환하고, 데이터를 재배치한다.")
            void pollAndRelocate() {
                ArrayQueue q = new ArrayQueue();

                q.add(1);
                q.add(2);
                q.add(3);

                assertEquals(1, q.poll());
                assertEquals("2,3", q.toString());
            }
        }
    }

}