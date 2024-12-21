package structure.linkedList;

import structure.Node;
import structure.Structure;

public class DoublyLinkedList<T> implements Structure<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void firstAdd(T value) {
        if (head == null) {
            head = tail = new Node<>(value);
        } else {
            Node<T> node = new Node<>(value);
            head.prev = node;
            node.next = head;
            head = node;
        }
        size++;
    }

    public void lastAdd(T value) {
        if (head == null) {
            head = tail = new Node<>(value);
        } else {
            Node<T> node = new Node<>(value);
            tail.next = node;
            node.prev = tail;
            tail = node;
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
        return head;
    }
}
