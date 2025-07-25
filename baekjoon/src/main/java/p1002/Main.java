package p1002;

import java.util.Scanner;

/**
 * 제목 : 터렛
 * 링크 : https://www.acmicpc.net/problem/1002
 * 분류 : 기하 알고리즘
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int r1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int r2 = sc.nextInt();

			System.out.println(turret(x1, y1, r1, x2, y2, r2));
		}
	}

	/**
	 * 두 원의 교점 개수를 구하는 함수
	 * 
	 * 기하학적 분석:
	 * - 두 원의 중심이 같은 경우: 반지름이 같으면 무한히 많은 교점(-1), 다르면 교점 없음(0)
	 * - 두 원의 중심이 다른 경우:
	 *   1) 외접 또는 내접: 교점 1개 (r1 + r2 = d 또는 |r1 - r2| = d)
	 *   2) 두 점에서 만남: 교점 2개 (|r1 - r2| < d < r1 + r2)
	 *   3) 만나지 않음: 교점 0개 (그 외의 경우)
	 * 
	 * @param x1, y1, r1 첫 번째 원의 중심 좌표와 반지름
	 * @param x2, y2, r2 두 번째 원의 중심 좌표와 반지름
	 * @return 교점의 개수 (-1: 무한개, 0: 없음, 1: 한 개, 2: 두 개)
	 */
	private static int turret(int x1, int y1, int r1, int x2, int y2, int r2) {
		int result = 0;
		
		// 두 원의 중심이 같은 경우
		if (x1 == x2 && y1 == y2) {
			if (r1 == r2) {
				result = -1; // 같은 원 -> 무한히 많은 교점
			} else {
				result = 0;  // 동심원이지만 반지름이 다름 -> 교점 없음
			}
		} else {
			double d = dist(x1, x2, y1, y2); // 두 원의 중심 거리
			
			// 외접 또는 내접하는 경우 (한 점에서 만남)
			if (r1 + r2 == d || Math.abs(r1 - r2) == d) {
				result = 1;
			}
			// 두 점에서 교차하는 경우
			if (r1 + r2 > d && Math.abs(r1 - r2) < d) {
				result = 2;
			}
			// 그 외의 경우는 result = 0 (만나지 않음)
		}
		return result;
	}

	private static double dist(int x1, int x2, int y1, int y2) {
		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}
}