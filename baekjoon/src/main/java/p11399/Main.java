package p11399;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			list.add(sc.nextInt());
		}

		list.sort(Comparator.naturalOrder());

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				sum = sum + list.get(j);
			}
		}

		System.out.println(sum);
	}
}