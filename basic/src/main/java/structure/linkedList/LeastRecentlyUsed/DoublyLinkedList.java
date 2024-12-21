package structure.linkedList.LeastRecentlyUsed;

import lombok.Getter;

@Getter
public class DoublyLinkedList<K, V> {
    private Node<K, V> head;
    private Node<K, V> tail;

    public DoublyLinkedList() {
        this.head = new Node<>(null, null);
        this.tail = new Node<>(null, null);
        head.next = tail;
        tail.prev = head;
    }

    protected void add(Node<K, V> node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    protected void toFront(Node<K, V> node) {
        remove(node);
        add(node);
    }

    protected Node<K, V> remove() {
        Node<K, V> node = tail.prev;
        remove(node);
        node.prev = null;
        node.next = null;
        return node;
    }

    protected void remove(Node<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    protected void print() {
        Node<K, V> node = head;
        while (node != null) {
            System.out.println(node);
            node = node.next;
        }
    }
}
