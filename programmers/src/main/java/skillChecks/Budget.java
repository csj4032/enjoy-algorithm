package skillChecks;

import java.util.Arrays;

public class Budget {

	public int solution(int[] d, int budget) {
		Arrays.sort(d);
		int sum = 0;
		for (int i = 1; i < d.length + 1; i++) {
			sum += d[i - 1];
			if (sum > budget) {
				return i - 1;
			} else if (sum == budget) {
				return i;
			}
		}
		if (sum < budget) {
			return d.length;
		} else {
			return 0;
		}
	}
}
