import java.util.Scanner;

import static java.lang.System.in;
/*
* URL : http://codingdojang.com/scode/449?answer=6680#answer_6680
* 최소 단위(1분)을 기준으로 X와 Y 복사기가 처리한 값을 더하고 목표한 페이지를 넘는지 확
*
* */
public class TwoPrinters {
	public static void main(String[] args) {
		Scanner sc = new Scanner(in);
		int t = sc.nextInt();
		int m[][] = new int[t][3];
		for (int i = 0; i < t; i++) {
			m[i][0] = sc.nextInt();
			m[i][1] = sc.nextInt();
			m[i][2] = sc.nextInt();
		}

		for (int i = 0; i < t; i++) {
			int x = m[i][0];
			int y = m[i][1];
			int n = m[i][2];
			int l;
			int k = 1;
			while (true) {
				l = (k / x) + (k / y);
				if (n <= l) {
					System.out.println(k);
					break;
				}
				k++;
			}
		}
	}
}