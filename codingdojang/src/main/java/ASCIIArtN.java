import java.util.Scanner;

import static java.lang.System.in;

public class ASCIIArtN {

	public static void main(String[] args) {
		int n = new Scanner(in).nextInt();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j == 0 || j == n - 1 || j == i) {
					System.out.print("N");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println("");
		}
	}
}