public class DoublyLinkedStack<E> implements Stack<E> {
    private DoublyLinkedList<E> data = new DoublyLinkedList<>();
    public void push(E element){
        this.data.addToHead(element);
    }
    public E pop(){
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
