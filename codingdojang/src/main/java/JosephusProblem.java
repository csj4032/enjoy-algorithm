import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;

/*
* 최초 배열을 생성 N번째 병사를 제외하고 남은 배열을 복사 하고 다시 N번째 병사를 검증을 한다.
* 병사가 한명 일 때 까지 검증 반복한다.
* 리스트로 구현했으면 조금 더 수월 할듯..
* */
public class JosephusProblem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		int f = 0;

		int[] q = new int[n];
		for (int i = 1; i <= n; i++) q[i - 1] = i;

		int[] q1 = Arrays.copyOf(q, q.length);


		while (true) {

			int l = q1.length;
			int[] q2 = new int[l];
			int m = f;
			for (int i = 1; i <= l; i++) {
				m = (i + f) % k;
				if (m != 0) {
					q2[(i - 1) % l] = q1[i - 1];
				}
			}

			f = m;

			int p = 0;
			for (int i = 0; i < l; i++) {
				if (q2[i] != 0) p++;
			}

			q1 = new int[p];
			int r = 0;
			for (int i = 0; i < l; i++) {
				if (q2[i] != 0) {
					q1[r] = q2[i];
					r++;
				}
			}

			if (r == 1) {
				System.out.println(q1[0]);
				break;
			}
		}
	}
}
