public class SinglyLinkedQueue<E> implements Queue<E>{
    private SinglyLinkedList<E> data = new SinglyLinkedList<>();
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
