package p19237;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int[][] map;
	static List<Shark> sharks;
	static int[] dy = new int[]{-1, 1, 0, 0};
	static int[] dx = new int[]{0, 0, -1, 1};

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var m = sc.nextInt();
		var k = sc.nextInt();
		map = new int[n][n];
		sharks = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				var num = sc.nextInt();
				map[i][j] = num;
				if (num != 0) {
					sharks.add(new Shark(num, i, j, k));
				}
			}
		}

		for (int i = 0; i < m; i++) sharks.get(i).direct = sc.nextInt();

		for (int i = 0; i < m; i++) {
			var shark = sharks.get(i);
			for (int j = 0; j < 4; j++) {
				for (int l = 0; l < 4; l++) {
					shark.priority[j][l] = sc.nextInt();
				}
			}
		}

		while (true) {

			if (sharks.size() == 1) {
				break;
			}
		}
	}
}

class Shark {
	int num;
	int y;
	int x;
	int smell;
	int direct;
	int priority[][] = new int[4][4];

	public Shark(int num, int y, int x, int smell) {
		this.num = num;
		this.y = y;
		this.x = x;
		this.smell = smell;
	}

	@Override
	public String toString() {
		return "Shark{" +
				"num=" + num +
				", smell=" + smell +
				", direct=" + direct +
				", priority=" + Arrays.toString(priority) +
				'}';
	}
}