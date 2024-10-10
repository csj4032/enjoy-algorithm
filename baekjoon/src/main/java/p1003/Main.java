package p1003;

import java.util.Scanner;

/**
 * 제목 : 구현
 * 단계 : 피보나치 함수
 * 힌트 :
 * 0의 경우
 * 0	1	2	3	4	5	6
 * 1	0	1	1	2	3	5
 * 1의 경우
 * 0	1	2	3	4	5	6
 * 0	1	1	2	3	5	8
 */
public class Main {

	static int[] z = new int[41];
	static int[] o = new int[41];

	public static void main(String[] args) {

		z[0] = 1;
		z[1] = 0;

		o[0] = 0;
		o[1] = 1;

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			for (int j = 2; j <= n; j++) {
				z[j] = z[j - 2] + z[j - 1];
			}
			for (int j = 2; j <= n; j++) {
				o[j] = o[j - 2] + o[j - 1];
			}
			System.out.println(z[n] + " " + o[n]);
		}
	}
}

class Item {
	String name;
	Integer age;

	public Item(String z, Integer o) {
		this.name = name;
		this.age = age;
	}

	@Override
	public boolean equals(Object ojb) {
		if (this == ojb) {
			return true;
		}
		if (ojb == null || getClass() != ojb.getClass()) {
			return false;
		}
		Item item = (Item) ojb;
		return name.equals(item.name) && age.equals(item.age);
	}
}