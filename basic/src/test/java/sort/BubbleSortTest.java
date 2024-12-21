package sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BubbleSortTest {

	@Test
	public void test() {
		int[] array = new int[]{10, 2, 3, 4, 5, 6, 7, 8, 9, 1};
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.sort(array);
		Assertions.assertArrayEquals(array, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
		Assertions.assertFalse(Arrays.equals(array, new int[]{10, 2, 3, 4, 5, 6, 7, 8, 9, 1}));
        System.out.println(Arrays.toString(array));
	}
}