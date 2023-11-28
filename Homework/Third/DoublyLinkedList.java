import java.util.NoSuchElementException;
import  java.util.Iterator;
public class DoublyLinkedList<E> implements Iterable<E>{
	private DoublyLinkedListNode<E> head;
    private DoublyLinkedListNode<E> tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    
    public DoublyLinkedListNode<E> getHead() { return head; }
    
    public DoublyLinkedListNode<E> getTail() { return tail; }
    
    public int size() {
        return size;
    }
    public boolean isEmpty(){
        return this.head == null;
    }
    public void addToHead(E new_data) {
        DoublyLinkedListNode<E> new_head = new DoublyLinkedListNode<E>(new_data);
        new_head.setNext(head);
        head = new_head;
        if (tail == null) { 
            tail = new_head; 
        }
        size = size + 1;
    }
    
    public void addToTail(E new_data) {
    	DoublyLinkedListNode<E> new_tail = new DoublyLinkedListNode<E>(new_data);
    	if (tail != null) {
            tail.setPrev(tail);
    		tail.setNext(new_tail);
    		tail = new_tail;
    	} else {
    		tail = new_tail;
    		head = new_tail;
    	}
    	size = size + 1;
    }

    public E get(int index) {
    	DoublyLinkedListNode<E> current_node = head;
    	int current_index = 0;
        if ((index >= 0) && (index < size)) {
            while (current_index < index) {
                current_node = current_node.getNext();
                current_index++;
            }
            return current_node.getData();
        }
        throw new java.util.NoSuchElementException("No such element available");
    }

    public void set(int index, E new_data) {
    	DoublyLinkedListNode<E> current_node = head;
        int current_index = 0;
        if ((index >= 0) && (index < size)) {
            while (current_index < index) {
                current_node = current_node.getNext();
                current_index++;
            }
            current_node.setData(new_data);
        } else {
            throw new java.util.NoSuchElementException("Index out of bounds");
        }
    }

    public int search(E data) {
        DoublyLinkedListNode<E> current_node = head;
        int current_index = 0;
        while (current_node != null) {
            if (data.equals(current_node.getData())) {
                return current_index;
            }
            current_node = current_node.getNext();
            current_index++;
         }
         return -1;
    }
    
    public E removeHead() {
        DoublyLinkedListNode<E> node;
        if (head == null) {
            throw new java.util.NoSuchElementException("No such element available");
        }
        node = head;
        this.head = head.getNext();
        this.size = size - 1;
        return node.getData();
    }

    public E removeTail() {
        DoublyLinkedListNode<E> node = head;
        E data;
        if (head == null) {
            throw new java.util.NoSuchElementException("No such element available");
        }
        if (head == tail) {
            data = tail.getData();
            head = tail = null;
            size = size - 1;
            return data;
        }
        while (node.getNext() != tail) { node = node.getNext(); }
        data = tail.getData();
        node.setNext(null);
        tail = node;
        size = size - 1;
        return data;
    }
    //If inserting head or tail index O(1) time complexity else O(n)
    public void insert(int index, E new_data){
        if(size == 0){
            addToHead(new_data);
        }
        if(index == size){
            addToTail(new_data);
        }
        else{
            for(int i = 0; i < index; i++){
                head = head.getNext();
            }
            addToHead(new_data);
        }
    }
    //If removing head or tail index O(1) time complexity else O(n)
    public void remove(int index){
        if(index == 0){
            removeHead();
        }
        if(index == size){
            removeTail();
        }
        else{
            for(int i = 0; i < index; i++){
                head = head.getNext();
            }
            removeHead();
        }
    }
    public class MyDoublyLinkedListIterator implements Iterator<E> {
        DoublyLinkedListNode<E> new_head = new DoublyLinkedListNode<E>();
        public MyDoublyLinkedListIterator() { head = new_head; }
        public boolean hasNext() { return head.getNext() != tail; }
        public E next() {
        if (!hasNext()) { throw new NoSuchElementException("No next element available"); }
        head = head.getNext();
        return head.getData();
        }
    }
    @Override
    public Iterator<E> iterator() { return new MyDoublyLinkedListIterator();}
}
