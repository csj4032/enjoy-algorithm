package p1316;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = 0;
		for (int i = 0; i < n; i++) {
			String[] str = sc.next().split("");
			List<String> list = new ArrayList<>();
			list.add(str[0]);
			boolean flag = true;
			for (int j = 1; j < str.length; j++) {
				String now = str[j];
				String prev = str[j - 1];
				if (list.contains(now) && !now.equals(prev)) {
					flag = false;
				} else {
					list.add(now);
				}
			}
			if (flag) m++;
		}
		System.out.println(m);
	}
}