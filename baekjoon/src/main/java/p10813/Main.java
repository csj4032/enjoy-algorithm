package p10813;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 제목: 공 바꾸기
 * 링크: https://www.acmicpc.net/problem/10813
 * 분류: 배열, 구현
 * 
 * 핵심 아이디어:
 * - 두 바구니의 공을 서로 바꾸는 swap 연산을 M번 수행
 * - 전형적인 두 값 교환(swap) 알고리즘 문제
 * 
 * 알고리즘 접근:
 * 1. 1부터 N까지 번호가 매겨진 바구니 배열 초기화
 * 2. 각 연산마다 두 위치의 값을 임시 변수를 사용해 교환
 * 3. 1-based 인덱스를 0-based로 변환하여 처리
 * 
 * 학습 개념:
 * - Swap 알고리즘 (두 값 교환)
 * - 임시 변수를 사용한 값 교환
 * - 배열 인덱스 접근과 조작
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();  // 바구니 개수
		int m = sc.nextInt();  // 연산 개수
		int[] nn = new int[n]; // 바구니 배열

		// 바구니 초기화 (1번부터 N번까지)
		for (int i = 0; i < n; i++) {
			nn[i] = i + 1;
		}

		// M번의 공 바꾸기 연산
		for (int i = 0; i < m; i++) {
			int p = sc.nextInt() - 1;  // 첫 번째 바구니 (0-based로 변환)
			int q = sc.nextInt() - 1;  // 두 번째 바구니 (0-based로 변환)
			
			// 두 바구니의 공을 교환 (swap)
			int pv = nn[p];  // p번째 바구니의 공을 임시 저장
			int qv = nn[q];  // q번째 바구니의 공을 임시 저장
			nn[p] = qv;      // p번째 바구니에 q의 공을 넣음
			nn[q] = pv;      // q번째 바구니에 p의 공을 넣음
		}

		// 최종 바구니 상태 출력
		System.out.println(Arrays.stream(nn).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
	}
}