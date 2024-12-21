package structure.linkedList;


import structure.Node;
import structure.Structure;

public class SinglyLinkedList<T> implements Structure<T> {

    private Integer size;
    private Node<T> head;
    private Node<T> tail;

    public SinglyLinkedList() {
        size = 0;
    }

    public void add(T value) {
        if (head == null) {
            head = new Node<>(value);
            tail = head;
        } else {
            tail.next = new Node<>(value);
            tail = tail.next;
        }
        size++;
    }

    public Node<T> remove(int index) {
        if (index == 0) return remove();
        Node<T> current = search(index - 1);
        Node<T> next = current.next;
        if (next == tail) {
            current.next = null;
            tail = current;
        } else {
            current.next = next.next;
        }
        next.next = null;
        size--;
        return next;
    }

    public Node<T> get(int index) {
        return search(index);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private Node<T> remove() {
        if (head == null) return null;
        head = head.next;
        if (head == null) tail = null;
        size--;
        return head;
    }

    private Node<T> search(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node<T> current = head;
        while (index-- > 0) current = current.next;
        return current;
    }

    @Override
    public structure.Node<T> head() {
        return null;
    }

    public static class Node<T> {
        public T value;
        public Node<T> next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Node{" + "value=" + value + ", next=" + next + '}';
        }

        @Override
        protected void finalize() throws Throwable {
            System.out.println("Node " + value + " is being garbage collected");
        }
    }
}
