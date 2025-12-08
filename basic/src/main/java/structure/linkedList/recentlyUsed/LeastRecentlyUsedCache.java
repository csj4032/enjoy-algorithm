package structure.linkedList.recentlyUsed;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class LeastRecentlyUsedCache<K, V> {

    @Getter
    private final int capacity;
    private final Map<K, DoublyLinkedNode<K, V>> map;
    private final DoublyLinkedList<K, V> linkedList;

    public LeastRecentlyUsedCache() {
        this(10);
    }

    public LeastRecentlyUsedCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.linkedList = new DoublyLinkedList<>();
    }

    public void put(K key, V value) {
        if (map.containsKey(key)) {
            DoublyLinkedNode<K, V> node = map.get(key);
            node.value = value;
            linkedList.toFront(node);
        } else {
            if (map.size() >= capacity) {
                DoublyLinkedNode<K, V> node = linkedList.removeTailPrev();
                map.remove(node.key);
            }
            DoublyLinkedNode<K, V> node = new DoublyLinkedNode<>(key, value);
            linkedList.add(node);
            map.put(key, node);
        }
    }

    public DoublyLinkedNode<K, V> get(K key) {
        if (!map.containsKey(key)) throw new IllegalArgumentException("Key not found");
        DoublyLinkedNode<K, V> node = map.get(key);
        linkedList.toFront(node);
        return node;
    }

    public void print() {
        linkedList.print();
    }
}
