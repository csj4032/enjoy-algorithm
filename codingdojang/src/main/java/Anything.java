import java.math.BigDecimal;
import java.util.Scanner;

import static java.lang.System.in;

/*
* URL : http://codingdojang.com/scode/510?answer=3836#answer_3836
* 홀수 개의 약수를 가지는 숫자는 완전제곱수 일 경우 (2 는 약간 특수한 경우)
* 예 2{1,2}, 4(2*2){1,2,4}, 9(3*3){1,3,9), 16(4*4){1,2,4,8,16}...
* */
public class Anything {
	public static void main(String[] args) {
		Scanner sc = new Scanner(in);

		BigDecimal aa = new BigDecimal(sc.next());
		BigDecimal bb = new BigDecimal(sc.next());

		double aaa = aa.doubleValue();
		double bbb = bb.doubleValue();
		double ccc = bbb - aaa;

		int ddd = (int) Math.sqrt(bbb) - (int) Math.sqrt(aaa);

		if (ddd == 0L) {
			System.out.println(0);
		} else {
			System.out.printf("%d / %.0f\n", ddd, ccc);
		}
	}
}