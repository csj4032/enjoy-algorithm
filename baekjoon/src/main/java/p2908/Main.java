package p2908;

import java.util.Scanner;

/**
 * 제목: 상수
 * 링크: https://www.acmicpc.net/problem/2908
 * 분류: 문자열, 구현
 * 
 * 핵심 아이디어:
 * - 상수는 두 수를 거꾸로 읽어서 더 큰 수를 말하는 문제
 * - 두 세자리 수를 각각 뒤집어서 더 큰 값을 찾음
 * - 예: 734, 893 → 437, 398 → 437이 더 크므로 437 출력
 * 
 * 알고리즘 접근:
 * 1. 두 개의 세자리 수를 입력받음
 * 2. StringBuffer의 reverse() 메서드로 각 수를 뒤집음
 * 3. 뒤집힌 수를 정수로 변환하여 크기 비교
 * 4. 더 큰 수를 출력
 * 
 * 학습 개념:
 * - StringBuffer의 reverse() 메서드 활용
 * - 문자열과 정수 간의 타입 변환
 * - 조건문을 이용한 최댓값 찾기
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();  // 첫 번째 세자리 수
		String m = sc.next();  // 두 번째 세자리 수

		// 첫 번째 수를 뒤집기
		StringBuffer sb = new StringBuffer();
		int nn = Integer.valueOf(sb.append(n).reverse().toString());
		
		// 두 번째 수를 뒤집기 (새로운 StringBuffer 생성)
		sb = new StringBuffer();
		int mm = Integer.valueOf(sb.append(m).reverse().toString());

		// 뒤집힌 두 수 중 더 큰 수 출력
		if (nn > mm) {
			System.out.println(nn);
		} else {
			System.out.println(mm);
		}
	}
}