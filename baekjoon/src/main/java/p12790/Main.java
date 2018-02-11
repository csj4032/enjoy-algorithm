package p12790;

import java.util.Scanner;

/**
 * 제목 : Mini Fantasy War
 * 분류 : 구현
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			int hp = sc.nextInt();
			int mp = sc.nextInt();
			int at = sc.nextInt();
			int de = sc.nextInt();
			int hpo = sc.nextInt();
			int mpo = sc.nextInt();
			int ato = sc.nextInt();
			int dpo = sc.nextInt();

			int dhp = hp + hpo;
			if (dhp < 1) {
				dhp = 1;
			}

			int dmp = mp + mpo;
			if (dmp < 1) {
				dmp = 1;
			}

			int dat = at + ato;
			if (dat < 0) {
				dat = 0;
			}

			int f = (dhp * 1) + (dmp * 5) + (dat * 2) + ((de + dpo) * 2);

			System.out.println(f);
		}
	}
}