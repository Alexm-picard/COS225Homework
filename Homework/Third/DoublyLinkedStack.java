public class DoublyLinkedStack<E> extends DoublyLinkedList<E> implements Stack<E> {
    private DoublyLinkedList<E> data;
    private int size;
    public void push(E element){
        this.data.addToHead(element);
        this.size += 1;
    }
    public E pop(){
        this.size -= 1;
        return this.data.removeHead();
    }
    public E peek(){
        return this.data.getHead().getData();
    }
    public boolean isEmpty(){
        return this.data.isEmpty();
    }
    public int size(){
        return this.data.size();
    }
}
