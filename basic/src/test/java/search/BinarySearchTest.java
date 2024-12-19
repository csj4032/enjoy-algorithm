package search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTest {

    @Test
    public void binarySearchTest() {
        BinarySearch binarySearch = new BinarySearch();
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertEquals(0, binarySearch.binarySearch(sortedArray, 1, 0, sortedArray.length - 1));
        assertEquals(1, binarySearch.binarySearch(sortedArray, 2, 0, sortedArray.length - 1));
        assertEquals(2, binarySearch.binarySearch(sortedArray, 3, 0, sortedArray.length - 1));
        assertEquals(3, binarySearch.binarySearch(sortedArray, 4, 0, sortedArray.length - 1));
        assertEquals(4, binarySearch.binarySearch(sortedArray, 5, 0, sortedArray.length - 1));
        assertEquals(5, binarySearch.binarySearch(sortedArray, 6, 0, sortedArray.length - 1));
        assertEquals(6, binarySearch.binarySearch(sortedArray, 7, 0, sortedArray.length - 1));
        assertEquals(7, binarySearch.binarySearch(sortedArray, 8, 0, sortedArray.length - 1));
        assertEquals(8, binarySearch.binarySearch(sortedArray, 9, 0, sortedArray.length - 1));
        assertEquals(9, binarySearch.binarySearch(sortedArray, 10, 0, sortedArray.length - 1));
        assertEquals(-1, binarySearch.binarySearch(sortedArray, 11, 0, sortedArray.length - 1));
    }
}