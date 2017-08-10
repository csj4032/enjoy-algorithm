import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Panda {

	static int n;
	static int m;
	static int[][] a;

	public static void main(String[] args) throws FileNotFoundException {
		String path = Panda.class.getResource("").getPath();
		Scanner sc = new Scanner(new File(path + "Panda.txt"));
		n = sc.nextInt();
		a = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				recursive(i, j, a[i][j], 0);
			}
		}

		System.out.println(m);
	}


	private static void recursive(int y, int x, int s, int c) {
		//좌
		System.out.print(s);
		if (x > 0 && s < a[y][x - 1]) {
			c = c + 1;
			recursive(y, x - 1, a[y][x - 1], c);
		}
		//상
		if (y > 0 && s < a[y - 1][x]) {
			c = c + 1;
			recursive(y - 1, x, a[y - 1][x], c);
		}
		//우
		if (x < n - 1 && s < a[y][x + 1]) {
			c = c + 1;
			recursive(y, x + 1, a[y][x + 1], c);
		}
		//하
		if (y < (n - 1) && s < a[y + 1][x]) {
			c = c + 1;
			recursive(y + 1, x, a[y + 1][x], c);
		}

		if (m < c) {
			m = c;
		}
	}
}