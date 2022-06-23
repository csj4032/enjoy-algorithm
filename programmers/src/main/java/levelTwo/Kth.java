package levelTwo;

import java.util.Arrays;

public class Kth {

	public static void main(String[] args) {
		Kth kTh = new Kth();
		System.out.println(kTh.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
	}

	public int findKthLargest(int[] nums, int k) {
		int length = nums.length;
		Arrays.sort(nums);
		return nums[length-k];
	}
}
