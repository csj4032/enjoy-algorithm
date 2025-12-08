package structure.linkedList.recentlyUsed;

import java.util.HashMap;
import java.util.Map;

public class MostRecentlyUsedCache<K, V> {

    private final int capacity;
    private final Map<K, DoublyLinkedNode<K, V>> map;
    private final DoublyLinkedList<K, V> linkedList;

    public MostRecentlyUsedCache() {
        this(10);
    }

    public MostRecentlyUsedCache(int capacity) {
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
                DoublyLinkedNode<K, V> node = linkedList.removeHeadNext();
                map.remove(node.key);
            }
            DoublyLinkedNode<K, V> node = new DoublyLinkedNode<>(key, value);
            linkedList.add(node);
            map.put(key, node);
        }
    }
}
