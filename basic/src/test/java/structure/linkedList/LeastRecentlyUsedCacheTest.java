package structure.linkedList;

import org.junit.jupiter.api.*;
import structure.linkedList.LeastRecentlyUsed.Cache;
import structure.linkedList.LeastRecentlyUsed.Node;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LeastRecentlyUsedCacheTest {

    @Test
    @Order(1)
    public void createCache() {
        Cache<String, String> cache = new Cache<>();
        assertNotNull(cache);
    }

    @Test
    @Order(2)
    public void createCacheSize() {
        Cache<String, String> cache = new Cache<>(10);
        assertEquals(10, cache.getCapacity());
    }

    @Test
    @Order(3)
    public void put() {
        Cache<String, String> cache = new Cache<>(10);
        cache.put("1", "one");
        cache.put("2", "two");
        cache.put("3", "three");
    }

    @Test
    @Order(4)
    @DisplayName("캐시의 용량을 초과 했을 경우 가장 오래된 Node 삭제")
    public void capacityOver() {
        Cache<String, String> cache = new Cache<>(3);
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
        Cache<String, String> cache = new Cache<>(5);
        cache.put("1", "one");
        cache.put("2", "two");
        cache.put("3", "three");
        cache.put("4", "four");
        cache.put("5", "five");
        Node<String, String> nodeFour = cache.get("4");
        Node<String, String> nodeTree = cache.get("3");
        cache.get("3");
        cache.get("4");
        cache.get("1");
        cache.print();
    }

    @Test
    @Order(6)
    @DisplayName("캐시에 노드 등록, 조회 후 용량을 초과 해서 다시 등록")
    public void putAndGetAndPut(){
        Cache<String, String> cache = new Cache<>(5);
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