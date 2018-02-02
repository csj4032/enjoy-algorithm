package leader;

public class EquiLeader {

	public static void main(String[] args) {
		//System.out.println(solution(new int[]{4, 4, 2, 5, 3, 4, 4, 4})); // 3
		//System.out.println(solution(new int[]{4, 3, 4, 4, 4, 2}));
		//System.out.println(solution(new int[]{1, 2, 1, 1, 2, 1}));
		//System.out.println(solution(new int[]{0})); // 0
		System.out.println(solution(new int[]{1, 2})); // 0
	}

	public static int solution(int[] A) {
		int n = A.length;
		int m = 0;

		for (int i = n - 1; i >= 0; i--) {
			int k = A[i];

			int p = 0;
			for (int j = i; j > 0; j--) {
				if (k == A[j]) {
					p++;
				}
			}

			int f = 0;
			for (int j = i; j < n; j++) {
				if (k == A[j]) {
					f++;
				}
			}

			System.out.println(p + " " + (i / 2) + " " + f + " "  +(n - i) / 2);

			if (p > ((i - 1) / 2) && f > (n - i) / 2) {
				m++;
			}
		}
		return m;
	}
}