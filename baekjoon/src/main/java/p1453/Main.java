package p1453;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < t; i++) {
			set.add(sc.nextInt());
		}

		System.out.println(t - set.size());
	}
}