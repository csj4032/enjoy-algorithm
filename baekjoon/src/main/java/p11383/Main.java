package p11383;

import java.util.Scanner;

public class Main {

	static String str[];
	static String str2[];

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var m = sc.nextInt();
		str = new String[n];
		str2 = new String[n];
		for (int i = 0; i < n; i++) {
			str[i] = sc.next();
		}

		for (int i = 0; i < n; i++) {
			str2[i] = sc.next();
		}

		var flag = true;
		for (int i = 0; i < n; i++) {
			var str11 = str[i];
			var str22 = str2[i];
			for (int j = 0; j < m; j++) {
				var s1 = str11.charAt(j);
				for (int k = j * 2; k < (j * 2) + 2; k++) {
					if (s1 != str22.charAt(k)) {
						flag = false;
						break;
					}
				}
			}
		}
		if (flag) {
			System.out.println("Eyfa");
		} else {
			System.out.println("Not Eyfa");
		}
	}
}
