package p2908;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		String m = sc.next();

		StringBuffer sb = new StringBuffer();
		int nn = Integer.valueOf(sb.append(n).reverse().toString());
		sb = new StringBuffer();
		int mm = Integer.valueOf(sb.append(m).reverse().toString());

		if( nn > mm) {
			System.out.println(nn);
		} else {
			System.out.println(mm);
		}
	}
}