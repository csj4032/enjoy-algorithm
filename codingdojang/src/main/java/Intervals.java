import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;

/*
* URL : http://codingdojang.com/scode/440?answer=6703#answer_6703
* 기둥과 기둥사이를 연상하면 쉽게 풀림
* 가둥을 셈 할것인지 기둥 사이를 셈 할것인
* */
public class Intervals {

	static int n;
	static int k = 1000000;
	static int s = 0;
	static int e = 0;
	static int a[];
	static int b[];
	static int c[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(in);

		n = sc.nextInt();
		a = new int[n];
		b = new int[n];
		c = new int[k];

		Arrays.fill(c, 0);

		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}

		for (int i = 1; i <= k; i++) {
			for (int j = 0; j < n; j++) {
				int s = a[j];
				int e = b[j];
				if (s <= i && e > i) {
					c[i - 1] = 1;
				}
			}
		}

		for (int i = 0; i < k; i++) {
			if (c[i] == 1 && s == 0) {
				s = i + 1;
			}
			if (c[i] == 0) {
				e = i + 1;
			}
			if (s != 0 && e != 0 && s < e) {
				System.out.println(s + " " + e);
				s = 0;
				e = 0;
			}
		}
	}
}