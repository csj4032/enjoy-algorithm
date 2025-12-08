package structure.linkedList.recentlyUsed;

import lombok.Getter;

@Getter
public class DoublyLinkedList<K, V> {
    private DoublyLinkedNode<K, V> head;
    private DoublyLinkedNode<K, V> tail;

    public DoublyLinkedList() {
        this.head = new DoublyLinkedNode<>(null, null);
        this.tail = new DoublyLinkedNode<>(null, null);
        head.next = tail;
        tail.prev = head;
    }

    public void add(DoublyLinkedNode<K, V> node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    protected void toFront(DoublyLinkedNode<K, V> node) {
        remove(node);
        add(node);
    }

    protected DoublyLinkedNode<K, V> removeTailPrev() {
        DoublyLinkedNode<K, V> node = tail.prev;
        remove(node);
        node.prev = null;
        node.next = null;
        return node;
    }

    protected DoublyLinkedNode<K, V> removeHeadNext() {
        DoublyLinkedNode<K, V> node = head.next;
        remove(node);
        node.prev = null;
        node.next = null;
        return node;
    }

    protected void remove(DoublyLinkedNode<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    protected void print() {
        DoublyLinkedNode<K, V> node = head;
        while (node != null) {
            System.out.println(node);
            node = node.next;
        }
    }
}
