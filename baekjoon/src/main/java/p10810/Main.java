package p10810;

import java.util.Arrays;
import java.util.Scanner;

import static java.util.stream.Collectors.joining;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] b = new int[n];
		for (int i = 0; i < m; i++) {
			int f = sc.nextInt() - 1;
			int t = sc.nextInt();
			int v = sc.nextInt();
			Arrays.fill(b, f, t, v);
		}
		System.out.println(Arrays.stream(b).mapToObj(String::valueOf).collect(joining(" ")));
	}
}