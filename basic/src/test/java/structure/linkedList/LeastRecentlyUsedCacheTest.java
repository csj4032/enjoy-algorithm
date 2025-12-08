package structure.linkedList;

import org.junit.jupiter.api.*;
import structure.linkedList.recentlyUsed.LeastRecentlyUsedCache;
import structure.linkedList.recentlyUsed.DoublyLinkedNode;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LeastRecentlyUsedCacheTest {

    @Test
    @Order(1)
    public void createCache() {
        LeastRecentlyUsedCache<String, String> cache = new LeastRecentlyUsedCache<>();
        assertNotNull(cache);
    }

    @Test
    @Order(2)
    public void createCacheSize() {
        LeastRecentlyUsedCache<String, String> cache = new LeastRecentlyUsedCache<>(10);
        assertEquals(10, cache.getCapacity());
    }

    @Test
    @Order(3)
    public void put() {
        LeastRecentlyUsedCache<String, String> cache = new LeastRecentlyUsedCache<>(10);
        cache.put("1", "one");
        cache.put("2", "two");
        cache.put("3", "three");
    }

    @Test
    @Order(4)
    @DisplayName("캐시의 용량을 초과 했을 경우 가장 오래된 Node 삭제")
    public void capacityOver() {
        LeastRecentlyUsedCache<String, String> cache = new LeastRecentlyUsedCache<>(3);
        cache.put("1", "one");
        cache.put("2", "two");
        cache.put("3", "three");
        cache.put("4", "four");
        cache.put("5", "five");
    }

    @Test
    @Order(5)
    @DisplayName("캐시에 존재 노드 조회, 가장 최근에 조회 노드 가장 앞으로 이동")
    public void get() {
        LeastRecentlyUsedCache<String, String> cache = new LeastRecentlyUsedCache<>(5);
        cache.put("1", "one");
        cache.put("2", "two");
        cache.put("3", "three");
        cache.put("4", "four");
        cache.put("5", "five");
        DoublyLinkedNode<String, String> nodeFour = cache.get("4");
        DoublyLinkedNode<String, String> nodeTree = cache.get("3");
        cache.get("3");
        cache.get("4");
        cache.get("1");
        cache.print();
    }

    @Test
    @Order(6)
    @DisplayName("캐시에 노드 등록, 조회 후 용량을 초과 해서 다시 등록")
    public void putAndGetAndPut(){
        LeastRecentlyUsedCache<String, String> cache = new LeastRecentlyUsedCache<>(5);
        cache.put("1", "one");
        cache.put("2", "two");
        cache.put("3", "three");
        cache.put("4", "four");
        cache.put("5", "five");
        cache.get("4");
        cache.get("3");
        cache.put("6", "six");
        cache.print();
    }
}