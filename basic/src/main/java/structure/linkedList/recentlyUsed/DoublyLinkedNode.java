package structure.linkedList.recentlyUsed;

public class DoublyLinkedNode<K, V> {
    protected K key;
    protected V value;
    protected DoublyLinkedNode<K, V> prev;
    protected DoublyLinkedNode<K, V> next;

    public DoublyLinkedNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "DoublyLinkedNode {" + "key=" + key + ", value=" + value + '}';
    }
}
