package p4344;

import java.util.Scanner;

/**
 * 백준 4344 - 평균은 넘겠지
 * 분류: 수학, 구현, 사칙연산
 * 
 * 핵심 개념:
 * - 각 테스트 케이스마다 평균을 넘는 학생들의 비율을 구하기
 * - 1단계: 평균 계산, 2단계: 평균을 넘는 학생 수 세기, 3단계: 비율 계산
 * 
 * 학습 포인트:
 * 1. 배열을 사용한 데이터 저장과 두 번의 순회
 * 2. 평균 계산과 비교 연산
 * 3. 소수점 출력 형식 지정 (printf 사용)
 * 
 * 시간복잡도: O(M) - M은 각 테스트 케이스의 학생 수
 * 공간복잡도: O(M) - 학생 수만큼 배열 사용
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt(); // 테스트 케이스 개수
		
		for (int i = 0; i < c; i++) {
			int n = sc.nextInt(); // 학생 수
			int[] scores = new int[n]; // 점수를 저장할 배열
			int sum = 0; // 점수 총합
			
			// 1단계: 점수 입력받으며 총합 계산
			for (int j = 0; j < n; j++) {
				scores[j] = sc.nextInt();
				sum += scores[j];
			}
			
			// 2단계: 평균 계산
			double average = (double) sum / n;
			
			// 3단계: 평균을 넘는 학생 수 세기
			int count = 0;
			for (int j = 0; j < n; j++) {
				if (scores[j] > average) {
					count++;
				}
			}
			
			// 4단계: 비율 계산 및 출력 (소수점 3자리까지)
			double ratio = (double) count / n * 100;
			System.out.printf("%.3f%%\n", ratio);
		}
	}
}