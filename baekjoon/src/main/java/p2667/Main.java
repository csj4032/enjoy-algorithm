package p2667;

import java.util.*;

public class Main {

	private static int m[][] = new int[25][25];
	private static int n;
	private static List<Integer> apartments = new ArrayList<>();
	private static int household;
	private static int apartment;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			String[] line = sc.next().split("");
			for (int j = 0; j < n; j++) {
				m[i][j] = Integer.valueOf(line[j]);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (m[i][j] == 1) {
					household = 0;
					apartment = apartment + 1;
					dfs(i, j);
					apartments.add(household);
				}
			}
		}
		System.out.println(apartment);
		apartments.stream().sorted().forEach(System.out::println);
	}

	private static void dfs(int i, int j) {
		m[i][j] = 0;
		household = household + 1;
		if (j + 1 < n && m[i][j + 1] == 1) dfs(i, j + 1);
		if (i - 1 >= 0 && m[i - 1][j] == 1) dfs(i - 1, j);
		if (j - 1 >= 0 && m[i][j - 1] == 1) dfs(i, j - 1);
		if (i + 1 < n && m[i + 1][j] == 1) dfs(i + 1, j);
	}
}