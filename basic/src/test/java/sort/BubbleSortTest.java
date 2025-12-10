package sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BubbleSortTest {

	@Test
	public void test() {
		int[] array = new int[]{20, 6, 55, 74, 3, 45, 13, 87, 46, 30};
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.sort(array);
		Assertions.assertArrayEquals(array, new int[]{3, 6, 13, 20, 30, 45, 46, 55, 74, 87});
		Assertions.assertFalse(Arrays.equals(array, new int[]{10, 2, 3, 4, 5, 6, 7, 8, 9, 1}));
        System.out.println(Arrays.toString(array));
	}
}