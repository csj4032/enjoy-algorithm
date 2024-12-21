package structure.linkedList.LeastRecentlyUsed;

public class Node<K, V> {
    protected K key;
    protected V value;
    protected Node<K, V> prev;
    protected Node<K, V> next;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" + "key=" + key + ", value=" + value + '}';
    }
}
