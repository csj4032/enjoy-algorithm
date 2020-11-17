package p20055;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 제목 : 컨베이어 벨트 위의 로봇
 * 링크 : https://www.acmicpc.net/problem/20055
 */
public class Main {

	private static ArrayList<Node> l;
	private static ArrayList<Robot> r;
	private static int t;

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var nn = n * 2;
		var k = sc.nextInt();
		l = new ArrayList<>();
		r = new ArrayList<>();
		for (int i = 0; i < nn; i++) l.add(new Node(sc.nextInt(), false));

		while (true) {
			l.add(0, l.remove(l.size() - 1));

			for (int i = r.size(); i > 0; i--) {
				r.get(i - 1).position += 1;
				if (r.get(i - 1).position >= n - 1) {
					r.remove(i - 1);
					l.get(n - 1).isRobot = false;
					continue;
				}
				var p = r.get(i - 1).position + 1;
				if (!l.get(p).isRobot && l.get(p).durability > 0) {
					l.get(p - 1).isRobot = false;
					l.get(p).isRobot = true;
					l.get(p).durability -= 1;
					r.get(i - 1).position += 1;
				}
			}

			if (l.get(0).durability > 0) {
				r.add(0, new Robot(0));
				l.get(0).isRobot = true;
				l.get(0).durability -= 1;
			}

			var cnt = 0;
			for (int i = 0; i < nn; i++) {
				if (l.get(i).durability <= 0) cnt++;
			}
			t++;
			if (cnt >= k) break;
		}
		System.out.println(t);
	}
}

class Robot {
	int position;

	public Robot(int position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Robot{position=" + position + '}';
	}
}

class Node {
	int durability;
	boolean isRobot;

	public Node(int durability, boolean isRobot) {
		this.durability = durability;
		this.isRobot = isRobot;
	}

	@Override
	public String toString() {
		return "Node{" + "durability=" + durability + '}';
	}
}
