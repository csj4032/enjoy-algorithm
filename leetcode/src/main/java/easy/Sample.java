package easy;

import java.util.*;
import java.util.stream.Collectors;

public class Sample {

	public static void main(String[] args) {

		int[] nums = new int[]{1, 2, 3, 4, 5};
		Arrays.sort(nums);

		int[][] nums2 = new int[][]{{1, 2}, {3, 4}};
		Arrays.sort(nums2, (a, b) -> b[0] - a[0]);

		Arrays.stream(nums).boxed().collect(Collectors.toList());

		LinkedHashMap linkedHashMap = new LinkedHashMap();
		Queue<Integer> queue = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();
		List<Integer> list = new ArrayList<>();

		Integer.toBinaryString(1);
		Integer.toString(1, 2);


	}
}
