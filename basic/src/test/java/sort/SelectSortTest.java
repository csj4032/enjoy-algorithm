package sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SelectSortTest {

    @Test
    public void testSortBasic() {
        SelectSort selectSort = new SelectSort();
        int[] input = {5, 3, 8, 6, 2};
        int[] expected = {2, 3, 5, 6, 8};
        selectSort.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testSortEmpty() {
        SelectSort selectSort = new SelectSort();
        int[] input = {};
        int[] expected = {};
        selectSort.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testSortAlreadySorted() {
        SelectSort selectSort = new SelectSort();
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        selectSort.sort(input);
        assertArrayEquals(expected, input);
    }

}