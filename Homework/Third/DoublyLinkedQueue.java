public class DoublyLinkedQueue<E> extends DoublyLinkedList<E> implements Queue<E>{
    private DoublyLinkedList<E> data;
    private int size;
    public void enqueue(E element){
        this.data.addToHead(element);
        this.size += 1;
    }
    public E dequeue(){
        this.size -= 1;
        return this.data.removeTail();
    }
    public E getFront(){
        return this.data.getTail().getData();
    }
    public boolean isEmpty(){
        return this.data.isEmpty();
    }
    public int size(){
        return this.data.size();
    }

}
