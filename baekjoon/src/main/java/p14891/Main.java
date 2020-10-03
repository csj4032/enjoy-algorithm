package p14891;

import java.util.*;

/**
 * 제목 : 톱니바퀴
 * 링크 : https://www.acmicpc.net/problem/14891
 * 분류 : 구현, 시뮬레이션
 */
public class Main {

	static List<LinkedList<Integer>> list = new ArrayList<>();
	static LinkedList<Integer> gear1 = new LinkedList();
	static LinkedList<Integer> gear2 = new LinkedList();
	static LinkedList<Integer> gear3 = new LinkedList();
	static LinkedList<Integer> gear4 = new LinkedList();

	static {
		list.add(gear1);
		list.add(gear2);
		list.add(gear3);
		list.add(gear4);
	}

	static int[] mm = {1, 2, 4, 8};
	static int max = 0;

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		for (int i = 0; i < 4; i++) {
			var line = sc.next().split("");
			for (int j = 0; j < 8; j++) {
				list.get(i).add(Integer.parseInt(line[j]));
			}
		}
		var k = sc.nextInt();
		for (int i = 0; i < k; i++) {
			var n = sc.nextInt();
			var c = sc.nextInt();
			var t1 = copy(n - 1);
			var t2 = copy(n - 1);
			var direct1 = c;
			var direct2 = c;

			rotation(n - 1, c);

			for (int j = n - 1; j > 0; j--) {
				var tt = list.get(j - 1);
				if (!t1.get(6).equals(tt.get(2))) {
					t1 = copy(j - 1);
					direct1 = direct1 * -1;
					rotation(j - 1, direct1);
				} else {
					break;
				}
			}

			for (int j = n + 1; j <= 4; j++) {
				var tt = list.get(j - 1);
				if (!t2.get(2).equals(tt.get(6))) {
					t2 = copy(j - 1);
					direct2 = direct2 * -1;
					rotation(j - 1, direct2);
				} else {
					break;
				}
			}
		}

		for (int i = 0; i < 4; i++) {
			if (list.get(i).getFirst() == 1) max += mm[i];
		}

		System.out.println(max);
	}

	private static LinkedList<Integer> copy(int n) {
		var q = list.get(n);
		var qq = new LinkedList<Integer>();
		for (int i = 0; i < 8; i++) {
			qq.add(q.get(i));
		}
		return qq;
	}

	private static LinkedList<Integer> rotation(int n, int c) {
		var q = list.get(n);
		if (c > 0) {
			q.addFirst(q.pollLast());
		} else {
			q.addLast(q.pollFirst());
		}
		return q;
	}

	private static void display(List<LinkedList<Integer>> list) {
		for (Deque<Integer> deque : list) {
			for (Integer i : deque) {
				System.out.print(i);
			}
			System.out.println();
		}
		System.out.println();
	}
}