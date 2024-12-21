package structure.linkedList.LeastRecentlyUsed;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class Cache<K, V> {

    @Getter
    private final int capacity;
    private final Map<K, Node<K, V>> map;
    private final DoublyLinkedList<K, V> linkedList;

    public Cache() {
        this(10);
    }

    public Cache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.linkedList = new DoublyLinkedList<>();
    }

    public void put(K key, V value) {
        if (map.containsKey(key)) {
            Node<K, V> node = map.get(key);
            node.value = value;
            linkedList.toFront(node);
        } else {
            if (map.size() >= capacity) {
                Node<K, V> node = linkedList.remove();
                map.remove(node.key);
            }
            Node<K, V> node = new Node<>(key, value);
            linkedList.add(node);
            map.put(key, node);
        }
    }

    public Node<K, V> get(K key) {
        if (!map.containsKey(key)) throw new IllegalArgumentException("Key not found");
        Node<K, V> node = map.get(key);
        linkedList.toFront(node);
        return node;
    }

    public void print() {
        linkedList.print();
    }
}
