package structure.linkedList;

public class CircularLinkedList<T> {

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

    public void print() {
        if (tail == null) {
            return;
        }
        Node<T> current = tail.next;
        do {
            System.out.print(current.value + " ");
            current = current.next;
        } while (current != tail.next);
        System.out.println();
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        Node() {
            value = null;
            next = null;
        }
    }
}
