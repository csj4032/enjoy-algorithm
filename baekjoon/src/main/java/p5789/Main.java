package p5789;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			String m = sc.next();
			char k = m.charAt(m.length() / 2 - 1);
			char j = m.charAt(m.length() / 2);
			if (k == j) {
				System.out.println("Do-it");
			} else {
				System.out.println("Do-it-Not");
			}
		}

		Map map = new HashMap();
		Map table = new Hashtable();
	}
}