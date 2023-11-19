
public class SinglyLinkedList<E> {
	private SinglyLinkedListNode<E> head;
    private SinglyLinkedListNode<E> tail;
    private int size;

    public SinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    
    public SinglyLinkedListNode<E> getHead() { return head; }
    
    public SinglyLinkedListNode<E> getTail() { return tail; }
    
    public int size() {
        return size;
    }

    public void addToHead(E new_data) {
        SinglyLinkedListNode<E> new_head = new SinglyLinkedListNode<E>(new_data);
        new_head.setNext(head);
        head = new_head;
        if (tail == null) { tail = new_head; }
        size = size + 1;
    }
    
    public void addToTail(E new_data) {
    	SinglyLinkedListNode<E> new_tail = new SinglyLinkedListNode<E>(new_data);
    	if (tail != null) {
    		tail.setNext(new_tail);
    		tail = new_tail;
    	} else {
    		tail = new_tail;
    		head = new_tail;
    	}
    	size = size + 1;
    }

    public E get(int index) {
    	SinglyLinkedListNode<E> current_node = head;
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
    	SinglyLinkedListNode<E> current_node = head;
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
        SinglyLinkedListNode<E> current_node = head;
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
        SinglyLinkedListNode<E> node;
        if (head == null) {
            throw new java.util.NoSuchElementException("No such element available");
        }
        node = head;
        head = head.getNext();
        size = size - 1;
        if (head == null) { tail = null; }
        return node.getData();
    }

    public E removeTail() {
        SinglyLinkedListNode<E> node = head;
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
    public void  insert(int index, E new_data){
        int i = head;
        while(i != tail)
    }
}
