package p2577;

import java.util.Scanner;

/**
 * 백준 2577 - 숫자의 개수
 * 분류: 구현, 수학
 * 
 * 핵심 개념:
 * - 세 개의 자연수를 곱한 결과에서 각 숫자(0~9)가 몇 번 나타나는지 세기
 * - 숫자를 문자열로 변환하여 각 자릿수 분석
 * 
 * 학습 포인트:
 * 1. 숫자를 문자열로 변환하는 방법 (String.valueOf())
 * 2. 문자열의 각 문자를 순회하며 분석하는 방법
 * 3. 배열을 이용한 카운팅 기법
 * 
 * 시간복잡도: O(d) - d는 곱한 결과의 자릿수
 * 공간복잡도: O(1) - 크기 10인 배열 사용
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 세 개의 자연수 입력받기
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		// 세 수의 곱 계산
		int result = a * b * c;
		
		// 0~9 각 숫자의 개수를 저장할 배열
		int[] count = new int[10];
		
		// 곱한 결과를 문자열로 변환
		String resultStr = String.valueOf(result);
		
		// 문자열의 각 문자를 순회하며 해당 숫자의 개수 증가
		for (int i = 0; i < resultStr.length(); i++) {
			char digit = resultStr.charAt(i);  // 각 자릿수 문자
			int num = digit - '0';             // 문자를 숫자로 변환
			count[num]++;                      // 해당 숫자의 개수 증가
		}
		
		// 0부터 9까지 각 숫자의 개수 출력
		for (int i = 0; i < 10; i++) {
			System.out.println(count[i]);
		}
	}
}