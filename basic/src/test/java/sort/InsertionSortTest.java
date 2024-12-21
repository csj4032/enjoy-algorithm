package sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class InsertionSortTest {

    @Test
    public void insertionSortTest() {
        InsertionSort insertionSort = new InsertionSort();
        int[] input = {5, 3, 8, 6, 2};
        int[] expected = {2, 3, 5, 6, 8};
        insertionSort.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testSortAlreadySorted() {
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        InsertionSort insertionSort = new InsertionSort();
        assertArrayEquals(expected, input);
    }
}