package structure.stack;

import structure.Node;
import structure.Structure;

public class Stack<T> implements Structure<T> {

    private Node<T> head;
    private int size = 0;

    public Stack() {
        head = null;
    }

    public void push(T value) {
        Node<T> node = new Node<>(value);
        node.next = head;
        head = node;
        size++;
    }

    public T pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        T value = head.value;
        head = head.next;
        size--;
        return value;
    }

    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return head.value;
    }

    public Node<T> head() {
        return head;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

}
