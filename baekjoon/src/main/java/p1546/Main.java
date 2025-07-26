package p1546;

import java.util.Scanner;

/**
 * 백준 1546 - 평균
 * 분류: 수학, 구현
 * 
 * 핵심 포인트:
 * - 모든 점수를 (점수/최고점)*100으로 조작한 후 평균 계산
 * - 수학적 변형: (sum/max)*100/n = sum*100/(max*n)
 * - 부동소수점 연산과 반올림 처리
 * 
 * 시간복잡도: O(N) - N개 점수를 한 번 순회
 * 공간복잡도: O(1)
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 과목의 개수
		float max = 0;        // 최고점
		float sum = 0;        // 점수의 총합
		
		// N개의 점수를 입력받으며 최고점과 총합 계산
		for (int i = 0; i < n; i++) {
			float score = sc.nextFloat();
			sum += score;
			if (max < score)
				max = score;
		}
		
		// 새로운 평균 = (총합/최고점)*100/과목수 = 총합*100/(최고점*과목수)
		System.out.printf("%.2f", Math.round(sum / (n * max) * 10000f) / 100f);
	}
}