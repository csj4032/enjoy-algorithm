package p10824;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 제목: 네 수
 * 링크: https://www.acmicpc.net/problem/10824
 * 분류: 문자열, 수학, 큰 수 연산
 * 
 * 핵심 아이디어:
 * - 네 개의 정수 A, B, C, D가 주어질 때
 * - AB(A와 B를 이어붙인 수)와 CD(C와 D를 이어붙인 수)의 합을 구하는 문제
 * - 큰 수가 될 수 있으므로 BigInteger 사용
 * 
 * 알고리즘 접근:
 * 1. A, B를 문자열로 이어붙여서 AB 생성
 * 2. C, D를 문자열로 이어붙여서 CD 생성
 * 3. BigInteger를 사용하여 AB + CD 계산
 * 
 * 학습 개념:
 * - 문자열 연결을 이용한 수 조합
 * - BigInteger를 이용한 큰 수 연산
 * - 수의 자릿수 계산과 조합 방법
 */
public class Main {

	private static long E, F, p = 1, q = 1;
	private static long A, B, C, D;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();  // 첫 번째 수
		B = sc.nextInt();  // 두 번째 수
		C = sc.nextInt();  // 세 번째 수
		D = sc.nextInt();  // 네 번째 수

		// 방법 1: 문자열 연결을 이용한 BigInteger 생성
		BigInteger k = new BigInteger(String.valueOf(A) + String.valueOf(B));  // AB
		BigInteger m = new BigInteger(String.valueOf(C) + String.valueOf(D));  // CD

		System.out.println(k.add(m));  // AB + CD 출력

		// 방법 2: 수학적 계산을 이용한 방법 (참고용)
		// B와 D의 자릿수를 계산하여 10의 거듭제곱으로 자리 이동
		E = B;
		F = D;

		// B의 자릿수만큼 10을 곱함 (A를 B의 자릿수만큼 왼쪽으로 이동)
		while (E > 0) {
			E /= 10;
			p *= 10;
		}

		// D의 자릿수만큼 10을 곱함 (C를 D의 자릿수만큼 왼쪽으로 이동)
		while (F > 0) {
			F /= 10;
			q *= 10;
		}

		// 검증용 출력 (실제 제출시에는 주석 처리)
		System.out.println(A * p + B);        // AB
		System.out.println(C * q + D);        // CD
		System.out.println(A * p + B + C * q + D);  // AB + CD
	}
}