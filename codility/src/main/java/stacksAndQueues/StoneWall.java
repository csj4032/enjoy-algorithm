package stacksAndQueues;

import java.util.Stack;

public class StoneWall {

	public int solution(int[] H) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < H.length; i++) {
			stack.push(H[i]);
		}
		return 0;
	}
}
