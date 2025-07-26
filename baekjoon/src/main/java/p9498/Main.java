package p9498;

import java.util.Scanner;

/**
 * 백준 9498 - 시험 성적
 * 분류: 구현
 * 
 * 핵심 개념:
 * - 시험 점수에 따른 학점 판정하기
 * - 다중 조건문(if-else if-else)의 사용
 * 
 * 점수 구간:
 * - 90~100: A
 * - 80~89: B  
 * - 70~79: C
 * - 60~69: D
 * - 0~59: F
 * 
 * 학습 포인트:
 * 1. 다중 조건문의 구조와 사용법
 * 2. 논리 연산자 (&&)를 이용한 범위 조건
 * 3. 조건의 순서가 중요함 (상위 점수부터 체크)
 * 4. else문을 이용한 나머지 경우 처리
 * 
 * 시간복잡도: O(1) - 상수 시간의 조건 체크
 * 공간복잡도: O(1) - 추가 공간 사용 최소
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 시험 점수 입력받기
		int score = sc.nextInt();
		
		// 점수 구간에 따른 학점 판정
		if (score >= 90 && score <= 100) {
			System.out.println("A");       // 90점 이상
		} else if (score >= 80 && score <= 89) {
			System.out.println("B");       // 80점 이상 90점 미만
		} else if (score >= 70 && score <= 79) {
			System.out.println("C");       // 70점 이상 80점 미만
		} else if (score >= 60 && score <= 69) {
			System.out.println("D");       // 60점 이상 70점 미만
		} else {
			System.out.println("F");       // 60점 미만
		}
	}
}