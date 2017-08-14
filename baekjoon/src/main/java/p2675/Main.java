package p2675;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		List list = new ArrayList();
		for (int i = 0; i < t; i++) {
			int r = sc.nextInt();
			String[] str = sc.next().split("");
			StringBuffer sb = new StringBuffer();
			for (int j = 0; j < str.length; j++) {
				for (int k = 0; k < r; k++) {
					sb.append(str[j]);
				}
			}
			list.add(sb.toString());
		}

		list.forEach(System.out::println);
	}
}