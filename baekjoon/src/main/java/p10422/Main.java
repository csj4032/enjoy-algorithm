package p10422;

import java.util.Scanner;

/**
 * 제목 : 괄호
 * 링크 : https://www.acmicpc.net/problem/10422
 * 분류 : 카탈란 수(catalan number)
 * <p>
 * 0 : 1
 * 1 : 1 	() 1*1 = 1
 * 2 : 2 	()() (()) 1*1 + 1*1 = 2
 * 3 : 5 	()()() ()(()) (())() (()()) ((()))
 * 4 : 14	()()()() ... (((()))) 5 + 2 + 2 + 5 = 14
 * 5 : 42	()()()()() ... ((((()))))  14 + 5 + 4 + 5 + 14 = 42
 * <p>
 * C1 = C0*C0
 * C2 = C0*C1 + C1*C0
 * C3 = C0*C2 + C1*C1 + C2C0
 */
public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
	}
}