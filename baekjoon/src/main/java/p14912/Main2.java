package p14912;

import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var d = sc.nextInt();
		var l = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			var loop = i;
			while (loop > 0) {
				l[loop % 10]++;
				loop /= 10;
			}
		}
		System.out.println(l[d]);
	}
}