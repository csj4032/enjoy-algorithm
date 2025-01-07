package structure.queue;

import structure.Node;
import structure.Structure;

public class Deque<T> implements Structure<T> {
    private Node<T> front;
    private Node<T> rear;
    private int size;

    public Deque() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public void addFront(T value) {
        Node<T> node = new Node<>(value);
        if (isEmpty()) {
            front = rear = node;
        } else {
            node.next = front;
            front.prev = node;
            front = node;
        }
        size++;
    }

    public void addRear(T value) {
        Node<T> node = new Node<>(value);
        if (isEmpty()) {
            front = rear = node;
        } else {
            node.prev = rear;
            rear.next = node;
            rear = node;
        }
        size++;
    }

    public T removeFront() {
        if (isEmpty()) throw new IllegalStateException("Deque is empty");
        T value = front.value;
        front = front.next;
        if (front == null) {
            rear = null;
        } else {
            front.prev = null;
        }
        size--;
        return value;
    }

    public T removeRear() {
        if (isEmpty()) throw new IllegalStateException("Deque is empty");
        T value = rear.value;
        rear = rear.prev;
        if (rear == null) {
            front = null;
        } else {
            rear.next = null;
        }
        size--;
        return value;
    }

    public T peekFront() {
        if (isEmpty()) throw new IllegalStateException("Deque is empty");
        return front.value;
    }

    public T peekRear() {
        if (isEmpty()) throw new IllegalStateException("Deque is empty");
        return rear.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public Node<T> head() {
        return front;
    }
}
