package structure.linkedList;

public class SinglyLinkedList<T> {

    private Node<T> head;

    private static class Node<T> {
        public T value;
        public Node<T> next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    public Integer size;

    public SinglyLinkedList() {
        size = 0;
    }

    public void add(T value) {
        if (head == null) {
            head = new Node<>(value);
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node<>(value);
        }
        size++;
    }

    public T remove(int index) {
        if (index == 0) {
            size--;
            return remove();
        }
        Node<T> current = search(index - 1);
        T value = current.next.value;
        current.next = current.next.next;
        size--;
        return value;
    }

    private T remove() {
        if (head == null) {
            return null;
        }
        Node<T> current = head;
        head = head.next;
        size--;
        return current.value;
    }

    public T get(int index) {
        return search(index).value;
    }

    public int size() {
        return size;
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
    }

    private Node<T> search(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = head;
        while (index-- > 0) {
            current = current.next;
        }
        return current;
    }
}
