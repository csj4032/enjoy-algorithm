package p1004;

import java.util.Scanner;

/**
 * 제목 : 어린 왕자
 * 풀이 : 주어진는 원들에 시작점과 끝점이 한쪽만 포함 되는지 확인
 */
public class Main {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int n = sc.nextInt();
			int c = 0;
			for (int j = 0; j < n; j++) {
				int cx = sc.nextInt();
				int cy = sc.nextInt();
				int r = sc.nextInt();
				if ((contain(x1, y1, cx, cy, r) && !contain(x2, y2, cx, cy, r)) || (!contain(x1, y1, cx, cy, r) && contain(x2, y2, cx, cy, r))) {
					c++;
				}
			}
			sb.append(c + "\n");
		}
		System.out.println(sb.toString());
	}

	private static boolean contain(int x, int y, int cx, int cy, int r) {
		if (Math.pow(r, 2) > (Math.pow(x - cx, 2) + Math.pow(y - cy, 2))) {
			return true;
		} else {
			return false;
		}
	}
}