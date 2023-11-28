
public class DoublyLinkedListNode<E> {
    private E data;
    private DoublyLinkedListNode<E> next;
    private DoublyLinkedListNode<E> prev;
    public DoublyLinkedListNode(E new_data) {
        data = new_data;
        next = null;
        prev = null;
    }
    public DoublyLinkedListNode() {
        next = null;
        prev = null;
    }
    public E getData() { return data; }
    public DoublyLinkedListNode<E> getNext() { return next; }
    public DoublyLinkedListNode<E> getPrev() { return prev; }
    public void setData(E new_data) { data = new_data; }
    public void setNext(DoublyLinkedListNode<E> new_next) { next = new_next; }
    public void setPrev(DoublyLinkedListNode<E> new_prev) { prev = new_prev; }
}
