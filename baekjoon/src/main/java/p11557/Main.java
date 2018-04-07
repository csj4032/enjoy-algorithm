package p11557;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			List<University> list = new ArrayList<>();
			int n = sc.nextInt();
			for (int j = 0; j < n; j++) {
				list.add(new University(sc.next(), sc.nextLong()));
			}
			list.sort(Comparator.comparing(University::getValue).reversed());
			System.out.println(list.get(0).name);
		}
	}
}

class University {
	public String name;
	public Long value;

	public University(String name, long value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return this.name;
	}

	public Long getValue() {
		return this.value;
	}
}
