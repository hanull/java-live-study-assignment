package queue;

public interface Queue {
    boolean add(int data);
    int poll();
    int peek();
}
