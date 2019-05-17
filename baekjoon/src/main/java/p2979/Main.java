package p2979;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		Truck t1 = new Truck(sc.nextInt(), sc.nextInt());
		Truck t2 = new Truck(sc.nextInt(), sc.nextInt());
		Truck t3 = new Truck(sc.nextInt(), sc.nextInt());

		int f = 0;

		for (int i = 0; i <= 100; i++) {
			int t = t1.contains(i) + t2.contains(i) + t3.contains(i);
			if (t == 1) {
				f += a;
			} else if (t == 2) {
				f += b * 2;
			} else if (t == 3) {
				f += c * 3;
			}
		}

		System.out.println(f);
	}
}

class Truck {
	int start;
	int end;

	Truck(int start, int end) {
		this.start = start;
		this.end = end;
	}

	int contains(int i) {
		if (start < i && i <= end) {
			return 1;
		}
		return 0;
	}
}