package p10974;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.joining;

// 순열
public class Main {

	static List<String> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] m = new int[n];
		for (int i = 1; i <= n; i++) {
			m[i - 1] = i;
		}
		recursive(0, n, m);
		display(list);
	}

	private static void recursive(int k, int n, int[] m) {
		if (k == n) {
			list.add(Arrays.stream(m).mapToObj(String::valueOf).collect(joining()));
			return;
		}

		for (int i = k; i < n; i++) {
			swap(m, i, k);
			recursive(k + 1, n, m);
			swap(m, i, k);
		}
	}

	private static void display(List<String> list) {
		list.stream().sorted().forEach(e -> {
			String[] s = e.split("");
			System.out.println(Arrays.stream(s).collect(joining(" ")));
		});
	}

	private static void swap(int[] m, int i, int k) {
		int a = m[i];
		m[i] = m[k];
		m[k] = a;
	}
}