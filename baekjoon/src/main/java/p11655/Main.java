package p11655;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		char[] chars = new Scanner(System.in).nextLine().toCharArray();
		StringBuilder stringBuilder = new StringBuilder();
		for (char c : chars) {
			if ((64 < c && c < 91) || (96 < c && c < 123)) {
				if (c < 91) {
					if (c + 13 > 90) {
						stringBuilder.append((char) (c + 13 - 90 + 64));
					} else {
						stringBuilder.append((char) (c + 13));
					}
				} else {
					if (c + 13 > 122) {
						stringBuilder.append((char) (c + 13 - 122 + 96));
					} else {
						stringBuilder.append((char) (c + 13));
					}
				}
			} else {
				stringBuilder.append(c);
			}
		}
		System.out.println(stringBuilder.toString());
	}
}