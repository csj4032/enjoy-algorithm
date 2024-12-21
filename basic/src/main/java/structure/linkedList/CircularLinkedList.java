package structure.linkedList;

import structure.Node;
import structure.Structure;

public class CircularLinkedList<T> implements Structure<T> {

    private Node<T> tail;
    private int size;

    public CircularLinkedList() {
        tail = null;
        size = 0;
    }

    public void add(T value) {
        Node<T> newNode = new Node<>();
        newNode.value = value;
        if (tail == null) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Node<T> head() {
        return tail;
    }
}
