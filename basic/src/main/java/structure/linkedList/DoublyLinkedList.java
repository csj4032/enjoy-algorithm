package structure.linkedList;

public class DoublyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    public void firstAdd(T value) {
        if (head == null) {
            head = tail = new Node<>(value);
        } else {
            Node<T> node = new Node<>(value);
            head.prev = node;
            node.next = head;
            head = node;
        }
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
    }

    public void print() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.value);
            if (current.next != null) System.out.print(" -> ");
            current = current.next;
        }
        System.out.println();
    }

    private static class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

        Node(T value) {
            this.value = value;
            next = null;
            prev = null;
        }
    }
}
