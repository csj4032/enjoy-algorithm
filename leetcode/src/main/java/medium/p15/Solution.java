package medium.p15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int j = i + 1;
			int k = nums.length - 1;
			if (i > 0 && nums[i] == nums[i - 1]) continue;
			while (j < k) {
				if (nums[i] + nums[j] + nums[k] > 0) {
					k--;
				} else if (nums[i] + nums[j] + nums[k] < 0) {
					j++;
				} else {
					while (j < k && nums[j] == nums[j + 1])
						j++;
					List<Integer> integers = new ArrayList<>();
					integers.add(nums[i]);
					integers.add(nums[j]);
					integers.add(nums[k]);
					result.add(integers);
					k--;
					j++;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		// System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
		// System.out.println(solution.threeSum(new int[]{-2, 0, 0, 2, 2}));
		System.out.println(solution.threeSum(new int[]{0, 0, 0}));
	}
}
