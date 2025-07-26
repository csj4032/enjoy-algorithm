package p10810;

import java.util.Arrays;
import java.util.Scanner;

import static java.util.stream.Collectors.joining;

/**
 * 제목: 공 넣기
 * 링크: https://www.acmicpc.net/problem/10810
 * 분류: 배열, 구현
 * 
 * 핵심 아이디어:
 * - N개의 바구니에 M번에 걸쳐 공을 넣는 시뮬레이션 문제
 * - 각 연산마다 특정 범위의 바구니에 같은 번호의 공을 넣음
 * 
 * 알고리즘 접근:
 * 1. 크기 N인 배열 생성 (초기값 0)
 * 2. M번의 연산을 순차적으로 수행
 * 3. Arrays.fill()을 사용하여 범위에 값을 효율적으로 설정
 * 
 * 학습 개념:
 * - 배열 범위 업데이트
 * - Arrays.fill() 메서드 활용
 * - 1-based와 0-based 인덱스 변환
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();  // 바구니 개수
		int m = sc.nextInt();  // 연산 개수
		int[] b = new int[n];  // 바구니 배열 (초기값 0)
		
		// M번의 공 넣기 연산
		for (int i = 0; i < m; i++) {
			int f = sc.nextInt() - 1;  // 시작 바구니 (0-based로 변환)
			int t = sc.nextInt();      // 끝 바구니 (1-based 그대로)
			int v = sc.nextInt();      // 공의 번호
			
			// f번째부터 t-1번째까지 v값으로 채우기
			// Arrays.fill(배열, 시작인덱스, 끝인덱스, 값)
			Arrays.fill(b, f, t, v);
		}
		
		// 최종 바구니 상태 출력
		System.out.println(Arrays.stream(b).mapToObj(String::valueOf).collect(joining(" ")));
	}
}