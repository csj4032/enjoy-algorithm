package p10811;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 제목: 바구니 뒤집기
 * 링크: https://www.acmicpc.net/problem/10811
 * 분류: 배열, 구현
 * 
 * 핵심 아이디어:
 * - N개의 바구니에서 특정 구간을 뒤집는 연산을 M번 수행
 * - 각 구간의 바구니 순서를 역순으로 배치
 * 
 * 알고리즘 접근:
 * 1. 1부터 N까지 번호가 매겨진 바구니 배열 초기화
 * 2. 각 연산마다 주어진 구간을 뒤집기
 * 3. Arrays.copyOfRange()로 구간을 복사하고 역순으로 배치
 * 
 * 학습 개념:
 * - 배열 구간 뒤집기 구현
 * - Arrays.copyOfRange() 활용
 * - 구간 처리에서 인덱스 변환 (1-based → 0-based)
 */
public class Main {

	static int n;
	static int m;
	static int[] nn;
	static StringBuilder sb;

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		n = sc.nextInt();  // 바구니 개수
		m = sc.nextInt();  // 연산 개수
		nn = new int[n];   // 바구니 배열
		sb = new StringBuilder();
		
		// 바구니 초기화 (1번부터 N번까지)
		for (int i = 0; i < n; i++) nn[i] = i + 1;
		
		// M번의 뒤집기 연산 수행
		for (int i = 0; i < m; i++) reverse(sc.nextInt(), sc.nextInt());
		
		// 결과 출력
		for (int i = 0; i < n; i++) sb.append(nn[i] + " ");
		System.out.println(sb.toString());
	}

	/**
	 * s번째부터 e번째까지 바구니를 뒤집는 메서드
	 * @param s 시작 위치 (1-based)
	 * @param e 끝 위치 (1-based)
	 */
	private static void reverse(int s, int e) {
		// 해당 구간을 복사
		int[] d = Arrays.copyOfRange(nn, s - 1, e);
		// 복사된 배열을 역순으로 원래 배열에 배치
		for (int i = 0; i < d.length; i++) {
			nn[s + i - 1] = d[d.length - i - 1];
		}
	}
}
