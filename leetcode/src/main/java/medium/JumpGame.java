package medium;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGame {

	public boolean canJump(int[] nums) {
		int currentReach = 0;
		for (int i = 0; i < nums.length; i++) {
			currentReach = Math.max(currentReach, i + nums[i]);
			if (currentReach > nums.length - 1) {
				return true;
			}
		}
		return false;
	}
}
