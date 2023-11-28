
//This class tests all the fetures implemented in DoublyLinkedQueue and Stack

public class TestDoublyLinkedList{
    public static void main(String[] args){
        DoublyLinkedQueue testQueue = new DoublyLinkedQueue<>();
        DoublyLinkedStack testStack = new DoublyLinkedStack<>();
        testStack.push(5);
        testStack.push(6);
        testStack.push(7);
        System.out.println(testStack.peek());
        System.out.println(testStack.isEmpty());
        System.out.println(testStack.size());
        System.out.println(testStack.pop());
        System.out.println(testStack.isEmpty());
        System.out.println(testStack.size());
        testStack.pop();
        System.out.println(testStack.isEmpty());
        System.out.println(testStack.size());
        testStack.pop();
        System.out.println(testStack.isEmpty());
        System.out.println(testStack.size());
        System.out.println();
        System.out.println();
        System.out.println();
        testQueue.enqueue(5);
        testQueue.enqueue(6);
        testQueue.enqueue(7);
        System.out.println(testQueue.getFront());
        System.out.println(testQueue.isEmpty());
        System.out.println(testQueue.size());
        testQueue.dequeue();
        System.out.println(testQueue.dequeue());
        System.out.println(testQueue.isEmpty());
        System.out.println(testQueue.size());
        testQueue.dequeue();
        System.out.println(testQueue.isEmpty());
        System.out.println(testQueue.size());
        testQueue.dequeue();
        System.out.println(testQueue.isEmpty());
        System.out.println(testQueue.size());
        }
}