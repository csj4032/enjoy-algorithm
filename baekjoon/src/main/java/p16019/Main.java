package p16019;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var m = sc.nextLine().split(" ");
		var l = m.length + 1;
		var ll = new int[l][l];

		for (int i = 0; i < l; i++) {
			for (int j = 0; j < l; j++) {
				var k = 0;
				if (i < j) {
					for (int n = i; n < j; n++) {
						k += Integer.parseInt(m[n]);
					}
				} else {
					for (int n = i; n > j; n--) {
						k += Integer.parseInt(m[n - 1]);
					}
				}
				if (i == j) k = 0;
				ll[i][j] = k;
			}
		}
		var sb = new StringBuilder();
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < l; j++) {
				sb.append(ll[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}