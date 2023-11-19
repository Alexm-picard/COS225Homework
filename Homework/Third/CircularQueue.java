
public class CircularQueue<E> implements Queue<E> {
	private E[] data;
    private int front;
    private int rear;
    private static final int DEFAULT_CAPACITY = 10;

    public CircularQueue() {
        this.data = (E[]) new Object[DEFAULT_CAPACITY];
        this.front = this.rear = -1;
    }
    
    public CircularQueue(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.front = this.rear = -1;
    }

    public void enqueue(E element) {
        if (((this.front == 0) && (this.rear == this.data.length - 1)) ||
            (this.rear == this.front - 1))  {
            System.out.println("Circular queue at capacity; unable to enqueue");
        } else if (this.front == -1) {
            this.data[0] = element;
            this.front = this.rear = 0;
        } else if (this.rear == this.data.length - 1) {
            this.data[0] = element;
            this.rear = 0;
        } else {
            this.data[this.rear + 1] = element;
            this.rear = this.rear + 1;
        }
    }

    public E dequeue() {
        E element;
        if (this.front == -1) {
            throw new java.util.NoSuchElementException("Empty queue; no element to dequeue");
        }
        if (this.front == this.rear) {
            element = this.data[this.front];
            this.front = this.rear = -1;
            return element;     
        } 
        if (this.front == this.data.length - 1) {
            this.front = 0;
            return this.data[this.data.length - 1];
        }
        this.front = this.front + 1;
        return this.data[this.front - 1];
    }

    public E getFront() {
        if (this.front == -1) {
            throw new java.util.NoSuchElementException("Empty queue; no element at front");
        }
        return this.data[this.front];
    }

    public boolean isEmpty() {
        return this.front == -1;
    }

    public int size() {
        if (this.front == -1) {
            return 0;
        }
        if (this.front > this.rear) {
            return this.data.length - (this.front - this.rear - 1);
        }
        return this.rear - this.front + 1;
    }
}
