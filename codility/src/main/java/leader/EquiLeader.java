package leader;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EquiLeader {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{4, 4, 2, 5, 3, 4, 4, 4})); // 3
		System.out.println(solution(new int[]{4, 3, 4, 4, 4, 2}));
		System.out.println(solution(new int[]{1, 2, 1, 1, 2, 1}));
		System.out.println(solution(new int[]{0})); // 0
		System.out.println(solution(new int[]{1, 2})); // 0
		System.out.println(solution(new int[]{-1000000000, -1000000000})); // 1
	}

	//static int[] k = new int[1000000001];

	public static int solution(int[] A) {

		int result = 0;

		for (int i = 1; i < A.length; i++) {

			int[] a = Arrays.copyOfRange(A, 0, i);
			int[] b = Arrays.copyOfRange(A, i, A.length);

			Map<Integer, Integer> m1 = new HashMap<>();
			Integer max = 0;
			Integer max2 = 0;
			Integer target = 0;
			for (int j = 0; j < a.length; j++) {
				if (m1.containsKey(a[j])) {
					m1.put(a[j], m1.get(a[j]) + 1);
				}
				m1.putIfAbsent(a[j], 1);
				if (max < m1.get(a[j])) {
					max = m1.get(a[j]);
					target = a[j];
				}

				if ((max + a.length - j) < (a.length / 2)) {
					break;
				}

				if ((max > a.length / 2)) {
					break;
				}
			}

			if ((max > a.length / 2)) {
				for (int j = 0; j < b.length; j++) {
					if (target.equals(b[j])) {
						max2++;
					}
					if ((max2 + b.length - j) < (b.length / 2)) {
						break;
					}
				}

				if ((max2 > b.length / 2)) {
					result++;
				}
			}
		}

		return result;
	}
}