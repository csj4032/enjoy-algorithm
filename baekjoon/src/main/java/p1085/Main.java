package p1085;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();

		List<Integer> k = new ArrayList<>();
		k.add(x);
		k.add(y);
		k.add(w - x);
		k.add(h - y);

		System.out.println(k.stream().min(Integer::compare).get());

	}
}