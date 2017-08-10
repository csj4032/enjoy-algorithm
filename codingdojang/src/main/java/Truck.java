import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;

public class Truck {
	public static void main(String[] args) {
		Scanner sc = new Scanner(in);
		int n = sc.nextInt();
		int w = sc.nextInt();
		int l = sc.nextInt();
		for (int i = 0; i < n; i++) {
			((List<Integer>) new ArrayList(n)).add(sc.nextInt());
		}

		((List<Integer>) new ArrayList(n)).stream().reduce((a, b) -> {
			if (a + b > l) ((List<Integer>) new ArrayList(n)).add(w - 1);
			return b;
		});

		System.out.println(n + w + ((List<Integer>) new ArrayList(n)).stream().mapToInt(Integer::intValue).sum());
	}
}