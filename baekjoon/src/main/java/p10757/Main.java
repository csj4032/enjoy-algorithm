package p10757;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 백준 10757 - 큰 수 A+B
 * 분류: 수학, 구현, 사칙연산, 임의 정밀도 / 큰 수 연산
 * 
 * 핵심 개념:
 * - 매우 큰 정수(최대 10^10000)의 덧셈 연산
 * - Java의 기본 정수 타입(int, long)으로는 처리 불가능
 * - BigInteger 클래스를 사용한 임의 정밀도 연산
 * 
 * 학습 포인트:
 * 1. BigInteger 클래스의 사용법
 * 2. 문자열을 BigInteger로 변환하는 방법
 * 3. BigInteger의 add() 메서드를 통한 덧셈
 * 4. 큰 수 연산의 필요성과 한계
 * 
 * BigInteger 주요 메서드:
 * - new BigInteger(String): 문자열로 BigInteger 생성
 * - add(BigInteger): 덧셈
 * - subtract(BigInteger): 뺄셈
 * - multiply(BigInteger): 곱셈
 * - divide(BigInteger): 나눗셈
 * 
 * 시간복잡도: O(n) - n은 큰 수의 자릿수
 * 공간복잡도: O(n) - 큰 수 저장 공간
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 큰 수를 문자열로 입력받아 BigInteger로 변환
		BigInteger a = new BigInteger(sc.next());
		BigInteger b = new BigInteger(sc.next());
		
		// BigInteger의 add 메서드로 덧셈 수행
		BigInteger result = a.add(b);
		
		// 결과 출력
		System.out.println(result);
	}
}