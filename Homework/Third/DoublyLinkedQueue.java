public class DoublyLinkedQueue<E> implements Queue<E>{
    private DoublyLinkedList<E> data = new DoublyLinkedList<>();
    public void enqueue(E element){
        this.data.addToHead(element);
    }
    public E dequeue(){
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
