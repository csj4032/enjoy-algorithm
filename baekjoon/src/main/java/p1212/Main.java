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

	public static void main(String[] args)  {

		String n = new Scanner(System.in).next();

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n.length(); i++) {
			sb.append(m.get(n.substring(i, i + 1)));
		}

		int k = sb.toString().indexOf("1");
		if(k != -1) {
			System.out.println(sb.toString().substring(k));
		} else{
			System.out.println("0");
		}
	}
}