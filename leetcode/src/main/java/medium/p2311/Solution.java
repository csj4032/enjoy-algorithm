package medium.p2311;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * 215. Kth Largest Element in an Array
 */
public class Solution {

	public int findKthLargest(int[] nums, int k) {
		return Arrays.stream(nums).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).get(k-1);
	}
}
