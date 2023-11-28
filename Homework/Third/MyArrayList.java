import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<E> implements Iterable<E> {
	
	private E[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    
    public MyArrayList() {
        this.data = (E[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public MyArrayList(int initial_capacity) {
        this.data = (E[]) new Object[initial_capacity];
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    private void doubleCapacity() {
        E[] new_data = (E[]) new Object[this.data.length * 2];
        for (int i = 0; i < this.data.length; i++) {
            new_data[i] = this.data[i];
        }
        this.data = new_data;
    }

    public void add(E element) {
        if (this.size == this.data.length) {
            doubleCapacity();
        }
        
        this.data[this.size] = element;
        this.size = this.size + 1;
    }

    public E get(int index) {
        if ((index >= 0) && (index < this.size)) { return this.data[index]; }
        throw new java.util.NoSuchElementException("No such element available");
    }

    public void set(int index, E element) {
        if ((index >= 0) && (index < this.size)) { 
            this.data[index] = element;
        } else {
            throw new java.util.NoSuchElementException("Index out of bounds");
        }
    }

    public int search(E element) {
        for (int i = 0; i < this.size; i++) {
            if (element.equals(this.data[i])) {
                return i;
            }
        }
        return -1;
    }
    
    public E removeFirst() {
        E first_elem;
        if (this.size <= 0) {
            throw new java.util.NoSuchElementException("No such element available");
        }
        first_elem = this.data[0];
        for (int i = 1; i < this.size; i++) {
            this.data[i-1] = this.data[i];
        }
        this.size = this.size - 1;
        return first_elem;
    }

    public E removeLast() {
        E last_elem;
        if (this.size <= 0) {
            throw new java.util.NoSuchElementException("No such element available");
        }
        last_elem = this.data[this.size - 1];
        this.size = this.size - 1;
        return last_elem;
    }
    
    public void insertAtBeginning(E element) {
    	if (this.size == this.data.length) { doubleCapacity(); }
    	for (int i = this.size-1; i >= 0; i--) {
    		this.data[i+1] = this.data[i];
    	}
    	this.data[0] = element;
    	this.size = this.size + 1;
    }
    public class MyArrayListIterator implements Iterator<E> {
        private int next_index;
        public MyArrayListIterator() { next_index = 0; }
        public boolean hasNext() { return next_index < size; }
        public E next() {
            E next_element;
            if (!hasNext()) { throw new NoSuchElementException("No next element available"); }
            next_element = data[next_index];
            next_index = next_index + 1;
            return next_element;
        }
    }
    //Insert method shifts the data then inserts the element at the index
    //Time complexity is O(n)
    public void insert(int index, E element){
        for(int i = size; i > index; i--){
            this.data[i] = this.data[i-1];
        }
        this.data[index] = element;
        this.size += 1;
    }
    //Remove method shifts the data and removes by overwriting the value  
    //Time complexity is O(n) for shifting
    public E remove(int index){
        E removed_element = this.data[index];
        for(int i = index; i < size-1; i++){
            this.data[i] = this.data[i+1];
        }
        this.size -= 1;
        return removed_element;
    }
	@Override
	public Iterator<E> iterator() {
		return new MyArrayListIterator();
	}
}
