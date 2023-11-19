
public interface Queue<E> {
    void enqueue(E element);
    E dequeue();
    E getFront();
    boolean isEmpty();
    int size();
}
