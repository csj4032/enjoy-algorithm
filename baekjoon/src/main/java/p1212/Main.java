package p1212;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	static Map m = new HashMap();

	static {
		m.put("0", "000");
		m.put("1", "001");
		m.put("2", "010");
		m.put("3", "011");
		m.put("4", "100");
		m.put("5", "101");
		m.put("6", "110");
		m.put("7", "111");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();

		System.out.println(Integer.toBinaryString(Integer.valueOf(n, 8)));

		for (int i = 0; i < n.length(); i++) {
			System.out.println(n.substring(i, i + 1));
		}
	}
}