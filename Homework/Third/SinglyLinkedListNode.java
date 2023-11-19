
public class SinglyLinkedListNode<E> {
    private E data;
    private SinglyLinkedListNode<E> next;
    public SinglyLinkedListNode(E new_data) {
        data = new_data;
        next = null;
    }
    public E getData() { return data; }
    public SinglyLinkedListNode<E> getNext() { return next; }
    public void setData(E new_data) { data = new_data; }
    public void setNext(SinglyLinkedListNode<E> new_next) { next = new_next; }
}
