/**
 * 백준 2338번: 긴 자릿수 계산
 * https://www.acmicpc.net/problem/2338
 * 
 * 문제 설명:
 * 매우 큰 두 정수 A, B가 주어졌을 때 A+B, A-B, A×B를 계산하는 문제
 * 일반적인 int나 long 타입으로는 처리할 수 없는 큰 수를 다루어야 함
 * 
 * 핵심 개념:
 * - 기본 입출력 (Scanner 사용)
 * - BigInteger 클래스 활용 (큰 정수 처리)
 * - BigInteger의 메서드들 (add, subtract, multiply)
 * - var 키워드 (타입 추론)
 * - 큰 수 연산의 필요성
 * 
 * 시간복잡도: O(n) - BigInteger 연산은 자릿수에 비례
 */
package p2338;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var a = sc.nextBigInteger();  // 첫 번째 큰 정수 입력
		var b = sc.nextBigInteger();  // 두 번째 큰 정수 입력
		
		// BigInteger를 이용한 큰 수 연산
		var aa = a.add(b);      // A + B (덧셈)
		var bb = a.subtract(b); // A - B (뺄셈)
		var cc = a.multiply(b); // A × B (곱셈)
		
		// 결과 출력
		System.out.println(aa);
		System.out.println(bb);
		System.out.println(cc);
	}
}
