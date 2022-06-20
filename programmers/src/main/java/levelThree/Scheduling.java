package levelThree;

import java.util.Arrays;

/**
 * 선입 선출 스케줄링
 */
public class Scheduling {

	public int solution(int n, int[] cores) {
		int answer = 0;
		int length = cores.length;
		int[] through = new int[length];
		int max = 0;
		int step = 0;
		while (n > 0) {
			for (int i = 0; i < length; i++) {
				int current = cores[i];
				if ((step % current) == 0) {
					n--;
					max++;
					through[i] = max;
					answer = i;
					if (n == 0) break;
				}
			}
			System.out.println(Arrays.toString(through) + " " + step);
			step++;
		}
		return answer + 1;
	}
}
