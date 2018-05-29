package p4606;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			String str = sc.next();
			System.out.println(str);
			if(str.equals("#")) {
				break;
			}
		}
	}
}