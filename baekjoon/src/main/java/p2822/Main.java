package p2822;

import java.util.Arrays;
import java.util.Scanner;

import static java.util.stream.Collectors.joining;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] m = new int[8];
		int[] l;
		int[] n = new int[8];
		int k = 0;

		for (int i = 0; i < 8; i++) {
			m[i] = sc.nextInt();
		}

		l = Arrays.copyOf(m, m.length);
		Arrays.sort(l);

		System.out.println(Arrays.toString(l));
		System.out.println(Arrays.toString(m));

		for (int i = 0; i < 8; i++) {
			for (int j = 3; j < 8; j++) {
				if (l[j] == m[i]) {
					n[i] = i + 1;
					k += l[i];
				}
			}
		}

		System.out.println(k);
		System.out.println(Arrays.stream(n).filter(e -> e != 0).mapToObj(e -> String.valueOf(e)).collect(joining(" ")));
	}
}