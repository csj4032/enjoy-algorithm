package p1267;

import java.util.Scanner;

/**
 * 제목: 핸드폰 요금
 * 링크: https://www.acmicpc.net/problem/1267
 * 분류: 수학, 구현
 * 
 * 핵심 아이디어:
 * - 두 가지 요금제를 비교하여 더 저렴한 것을 찾는 문제
 * - Y요금제: 30초마다 10원
 * - M요금제: 60초마다 15원
 * 
 * 알고리즘 접근:
 * 1. 각 통화 시간에 대해 Y요금제와 M요금제 비용 계산
 * 2. Y요금제: (t/30 + 1) * 10 (올림 연산)
 * 3. M요금제: (t/60 + 1) * 15 (올림 연산)
 * 4. 총 비용을 비교하여 더 저렴한 요금제 결정
 * 
 * 학습 개념:
 * - 올림 연산(Ceiling)을 위한 사용자 정의 함수
 * - 조건문을 이용한 최소값 찾기
 * - 시간 기반 비용 계산 알고리즘
 */
public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();  // 통화 개수
		var m = 0;  // M요금제 전체 비용
		var y = 0;  // Y요금제 전체 비용
		
		// 각 통화에 대해 Y요금제와 M요금제 비용 계산
		for (int i = 0; i < n; i++) {
			var t = sc.nextInt();  // 통화 시간(초)
			y += mod(t, 30) * 10;   // Y요금제: 30초마다 10원
			m += mod(t, 60) * 15;   // M요금제: 60초마다 15원
		}
		
		// 두 요금제 비교하여 결과 출력
		if (m == y) {
			System.out.println("Y M " + y);  // 둘 다 같음
		} else if (m < y) {
			System.out.println("M " + m);   // M요금제가 더 저렴
		} else {
			System.out.println("Y " + y);   // Y요금제가 더 저렴
		}
	}

	/**
	 * 올림 연산을 수행하는 메서드
	 * t초 통화에 대해 k초 단위로 몇 번의 요금이 부과되는지 계산
	 * @param t 통화 시간(초)
	 * @param k 요금 단위 시간(초)
	 * @return 부과되는 요금 단위 개수
	 */
	private static int mod(int t, int k) {
		var s = 0;  // 요금 단위 개수
		
		// t초를 k초 단위로 나눈 것의 올림값 계산
		// 예: 35초 통화에 30초 단위 -> 2번 부과 (0-30초, 30-60초)
		while (t > -1) {
			t = t - k;  // k초씩 차감
			s++;        // 요금 단위 증가
		}
		return s;
	}
}
