package medium;

import java.util.Arrays;

public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
		if (nums.length == 1) return nums[0];
		int len = nums.length;
		int[] dp = new int[len];
		dp[0] = nums[0];
		int max = dp[0];
		for (int i = 1; i < len; i++) {
			dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
			if (max < dp[i]) max = dp[i];
		}
		return max;
	}
}