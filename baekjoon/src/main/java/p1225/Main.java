package p1225;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * 제목 : 이상한 곱셈
 * 설명 : A, B의 각자리 수를 각각 더하고 곱하면 됨 ㅡ_ㅡ;;
 */
public class Main {

	public static void main(String[] args) {
		//solution();
		solution2();
	}

	public static void solution() {
		Scanner sc = new Scanner(System.in);
		String[] a = sc.next().split("");
		String[] b = sc.next().split("");
		BigDecimal s = new BigDecimal(BigInteger.ZERO);
		for (String i : a) {
			BigDecimal k = new BigDecimal(i);
			for (String j : b) {
				BigDecimal t = new BigDecimal(j);
				s = s.add(t.multiply(k));
			}
		}
		System.out.println(s);
	}

	public static void solution2() {
		Scanner sc = new Scanner(System.in);
		String[] a = sc.next().split("");
		String[] b = sc.next().split("");

		BigInteger aa = BigInteger.ZERO;
		for (int i = 0; i < a.length; i++) {
			aa = aa.add(new BigInteger(a[i]));
		}

		BigInteger bb = BigInteger.ZERO;
		for (int i = 0; i < b.length; i++) {
			bb = bb.add(new BigInteger(b[i]));
		}

		System.out.println(aa.multiply(bb));
	}
}