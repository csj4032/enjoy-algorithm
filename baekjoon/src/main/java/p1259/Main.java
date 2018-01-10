package p1259;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			String n = sc.next();
			if (n.equals("0")) break;
			if(n.equals(new StringBuilder(n).reverse().toString())){
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}
}
