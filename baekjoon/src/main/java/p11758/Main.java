package p11758;

import java.util.Scanner;

/**
 * 제목 : CCW
 * 링크 : https://www.acmicpc.net/problem/11758
 * 분류 : 기하학
 * 기타 : https://degurii.tistory.com/47
 */
public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var a1 = sc.nextInt();
		var b1 = sc.nextInt();
		var a2 = sc.nextInt();
		var b2 = sc.nextInt();
		var a3 = sc.nextInt();
		var b3 = sc.nextInt();

		var r1 = (a3 - a1) * (b3 - b1);
		var r2 = (b2 - b1) * (a3 - a1);

		if (r1 < r2) {
			System.out.println("-1");
		} else if (r1 > r2) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}
	}
}
//1 1 0
//5 5 0
//7 10 3