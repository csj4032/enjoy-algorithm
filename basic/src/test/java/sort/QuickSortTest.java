package sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    public void testSortBasic() {
        QuickSort quickSort = new QuickSort();
        int[] input = {5, 3, 8, 6, 2};
        int[] expected = {2, 3, 5, 6, 8};
        quickSort.sort(input, 0, input.length - 1);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testSortEmpty() {
        QuickSort quickSort = new QuickSort();
        int[] input = {};
        int[] expected = {};
        quickSort.sort(input, 0, input.length - 1);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testSortAlreadySorted() {
        QuickSort quickSort = new QuickSort();
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        quickSort.sort(input, 0, input.length - 1);
        assertArrayEquals(expected, input);
    }
}