package structure.queue;


import structure.Node;
import structure.Structure;

public class Queue<T> implements Structure<T> {

    private Node<T> front;
    private Node<T> rear;
    private int size;

    public Queue() {
        this.front = null;
        this.rear = null;
    }

    public void enqueue(T value) {
        Node<T> node = new Node<>(value);
        if (front == null) {
            front = rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
        size++;
    }

    public T dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        T value = front.value;
        front = front.next;
        if (front == null) rear = null;
        size--;
        return value;
    }

    public Node<T> head() {
        return front;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
