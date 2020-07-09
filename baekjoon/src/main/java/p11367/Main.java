package p11367;

import java.util.Scanner;

public class Main {

	static String[] grade = new String[]{"A+", "A", "B+", "B", "C+", "C", "D+", "D", "F"};
	static int[] point = new int[]{97, 90, 87, 80, 77, 70, 67, 60, 0};

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var sb = new StringBuilder();
		var sb2 = new StringBuilder();
		for (int i = 0; i < n; i++) {
			var name = sc.next();
			var p = sc.nextInt();
			var g = grade(p);

			int k = 0;
			while (point[k] > p) {
				k++;
			}

			sb.append(name + " " + g + "\n");
			sb2.append(name + " " + grade[k] + "\n");
		}
		System.out.println(sb.toString());
		System.out.println(sb2.toString());
	}

	private static String grade(int p) {
		var g = "F";
		if (97 <= p && 100 >= p) {
			g = "A+";
		} else if (90 <= p && 96 >= p) {
			g = "A";
		} else if (87 <= p && 89 >= p) {
			g = "B+";
		} else if (80 <= p && 86 >= p) {
			g = "B";
		} else if (77 <= p && 79 >= p) {
			g = "C+";
		} else if (70 <= p && 76 >= p) {
			g = "C";
		} else if (67 <= p && 69 >= p) {
			g = "D+";
		} else if (60 <= p && 66 >= p) {
			g = "D";
		}
		return g;
	}
}