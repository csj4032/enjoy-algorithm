package search;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BinarySearchTest {

    @Test
    @Order(1)
    public void createTest() {
        BinarySearch binarySearch = new BinarySearch();
        assertNotNull(binarySearch);
    }

    @Test
    @Order(2)
    public void binarySearchTest() {
        BinarySearch binarySearch = new BinarySearch();
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertEquals(0, binarySearch.binarySearch(sortedArray, 1, 0, sortedArray.length - 1));
        assertEquals(1, binarySearch.binarySearch(sortedArray, 2, 0, sortedArray.length - 1));
        assertEquals(2, binarySearch.binarySearch(sortedArray, 3, 0, sortedArray.length - 1));
        assertEquals(3, binarySearch.binarySearch(sortedArray, 4, 0, sortedArray.length - 1));
        assertEquals(9, binarySearch.binarySearch(sortedArray, 10, 0, sortedArray.length - 1));
    }
}