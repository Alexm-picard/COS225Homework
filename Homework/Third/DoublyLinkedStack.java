public class DoublyLinkedStack<E> implements Stack<E> {
    private DoublyLinkedListNode<E> data;
    private int size;
    public void push(E element){
        DoublyLinkedListNode<E> node = new DoublyLinkedListNode<E>();
        
        addToHead(node);
    }
    public E pop(){
        DoublyLinkedListNode<E> node = new DoublyLinkedListNode<E>();
        node = removeHead();
        return node;
    }
    public E peek(){
        DoublyLinkedListNode<E> node = new DoublyLinkedListNode<E>();
        node = getHead();
        return node;
    }
    public boolean isEmpty(){
        return isEmpty();
    }
    public int size(){
        return size();
    }
}
