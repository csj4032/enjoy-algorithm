package p10991;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 제목: 별 찍기 - 16
 * 링크: https://www.acmicpc.net/problem/10991
 * 분류: 구현, 반복문
 * 
 * 핵심 아이디어:
 * - 별과 공백이 번갈아 나타나는 이등변삼각형 패턴
 * - 1번째 줄: 공백(N-1)개 + *, 2번째 줄: 공백(N-2)개 + * *, ...
 * - i번째 줄에는 (i+1)개의 별이 공백과 번갈아가며 배치
 * - 예(N=4): "   *", "  * *", " * * *", "* * * *"
 * 
 * 알고리즘 접근:
 * 1. 2차원 배열을 사용하여 전체 패턴 생성
 * 2. 각 줄에 대해 별의 위치를 계산하여 배치
 * 3. 별들 사이에 공백을 넣어 적절한 간격 유지
 * 4. 불필요한 공백 제거하여 출력
 * 
 * 학습 개념:
 * - 2차원 배열을 이용한 패턴 설계
 * - 별과 공백의 배치 규칙 이해
 * - 배열 초기화와 조건에 따른 출력 제어
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();  // 별 패턴의 크기
		int l = n * 2 - 1;    // 각 줄의 최대 길이
		char[][] m = new char[n][l];  // 패턴을 저장할 2차원 배열

		// 모든 위치를 공백으로 초기화
		for (int i = 0; i < n; i++) {
			Arrays.fill(m[i], ' ');
		}

		// 각 줄에 별 배치
		for (int i = 0; i < n; i++) {
			// i번째 줄에 (i+1)개의 별 배치
			for (int j = 0; j < i + 1; j++) {
				// 별의 위치: 시작점(n-i-1) + j*2 (별 사이에 공백 1개씩)
				m[i][(n - i - 1) + (j * 2)] = '*';
			}
		}

		// 패턴 출력
		for (int i = 0; i < n; i++) {
			int star = 0;  // 현재 줄에서 출력한 별 개수
			for (int j = 0; j < l; j++) {
				char c = m[i][j];
				if (c == '*') {
					star++;  // 별 개수 증가
				}
				System.out.print(m[i][j]);
				// 현재 줄의 모든 별을 출력하면 종료
				if (star == i + 1) {
					break;
				}
			}
			System.out.println();  // 줄바꿈
		}
	}
}