package p4811;

public class Main {

	static int n;
	static long[][] map = new long[31][31];

	public static void main(String[] args) {
		System.out.println(recursive(30, 0));
	}

	private static long recursive(int w, int h) {
		if (w > 0) {
			if (map[w][h] != 0) {
				return map[w][h];
			}
		}
		if (w == 0) {
			map[w][h] = 1;
			return 1;
		} else {
			long sum = 0;
			sum += recursive(w - 1, h + 1);
			if (h >= 1) {
				sum += recursive(w, h - 1);
			}
			map[w][h] = sum;
			return sum;
		}
	}
}
