package p11179;

import java.util.Scanner;

/**
 * 제목 : 2진수 뒤집기
 * 링크 : https://www.acmicpc.net/problem/20056
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		String rs = new StringBuffer(Integer.toBinaryString(s)).reverse().toString();
		System.out.println(Integer.valueOf(rs, 2));
	}
}