package sort;

import org.junit.jupiter.api.Test;

public class MergeSortTest {

    @Test
    public void insertionSortTest() {
        MergeSort mergeSort = new MergeSort();
        int[] input = {5, 3, 8, 6, 2, 1, 7, 4};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
        mergeSort.sort(input);
        //assertArrayEquals(expected, input);
    }
}