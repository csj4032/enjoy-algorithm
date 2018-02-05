package woowaBrothers.p2018;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Solution3 {

	public static void main(String[] args) {
		//System.out.println(solution(new int[]{40, 40, 100, 80, 20}, new int[]{3, 3, 2, 2, 3}, 3, 5, 200)); //6
		System.out.println(solution(new int[]{60, 80, 40}, new int[]{2, 3, 5}, 3, 5, 200)); // 5
		//System.out.println(solution(new int[]{60, 80, 40}, new int[]{2, 3, 5}, 5, 2, 200)); // 5
	}

	private static int solution(int[] A, int[] B, int M, int X, int Y) {
		int S = 0;
		int W = 0;
		int P = 1;
		Integer[] C = new Integer[X];
		Arrays.fill(C, 0);
		for (int i = 0; i < A.length; i++) {
			//System.out.println(A[i]);
			//System.out.println((i / M) * M + (i % M));
			//System.out.println(P);
			W = W + A[i];
			C[i % X] = B[(i / X) * X + (i % X)];
			//System.out.println(Arrays.toString(C));
			if ((P % X) == 0 || i == A.length - 1 || W >= Y) {
				if (W > Y){
					C[i] = 0;
					i--;
				}
				//System.out.println("!!!");
				//System.out.println(Arrays.toString(C));
				P = 1;
				W = 0;
				Set<Integer> targetSet = new HashSet<>();
				Collections.addAll(targetSet, C);
				//System.out.println(targetSet);
				for (int k = 0; k < M; k++) {
					if (targetSet.contains(k)) {
						//System.out.println("Stop");
						S++;
					}
				}
				Arrays.fill(C, 0);
				S++;
			}
			P++;
		}
		return S;
	}
}

