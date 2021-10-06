package p4592;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (1 == 1) {
			String[] str = sc.nextLine().split(" ");
			if (str[0].equals("0")) break;
			StringBuffer result = new StringBuffer();
			String flag = "";
			for (int i = 1; i < str.length; i++) {
				if (!flag.equals(str[i])) {
					flag = str[i];
					result.append(str[i]);
					result.append(" ");
				}
			}
			result.append("$");
			System.out.println(result);
		}
	}
}
