package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TargetNumberTest {

	public int solution(int[] numbers, int target) {
		//System.out.println(new TargetNumber().dfs(numbers, target));
		//System.out.println(new TargetNumber().dfs2(numbers, 0, 0, target));
		//System.out.println(new TargetNumber().bfs(numbers, target));
		//new TargetNumber().bfs(numbers, target);
		//int answer = new TargetNumber().dfs(numbers, target);
		for (int i = 0; i < 5; i++) {
			String s = String.format("%" + 6 + "s", Integer.toBinaryString(i)).replace(" ", "0");
			String[] ss =s.split("");
			long sum = 0;
			for (int j = 0; j < ss.length; j++) {
				if(ss[j].equals("0")) {
					sum -= numbers[i];
				} else {
					sum += numbers[i];
				}
			}
		}

		return 0;
	}

	@Test
	public void test() {
		solution(new int[]{1, 1, 1}, 3);
		//Assertions.assertEquals(5, solution(new int[]{1, 1, 1, 1, 1}, 3));
	}
}