package p4101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String[] arr = br.readLine().split(" ");
			int a = Integer.parseInt(arr[0]);
			int b = Integer.parseInt(arr[1]);

			if (a == 0 && b == 0) break;

			if (a > b) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
	}
}