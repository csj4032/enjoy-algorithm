package p4344;

import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer n = sc.nextInt();
		Integer[][] nn = new Integer[n][];

		for (int i = 0; i < n; i++) {
			int m = sc.nextInt();
			nn[i] = new Integer[m];
			for (int j = 0; j < m; j++) {
				nn[i][j] = sc.nextInt();
			}
			double avg = Stream.of(nn[i]).mapToDouble(Integer::intValue).average().orElse(0);
			double high = Stream.of(nn[i]).filter(k -> avg < k).count();
			System.out.println(String.format("%.3f", Math.round((high / m) * 100000f) / 1000f) + "%");
		}
	}
}