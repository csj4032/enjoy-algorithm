package p3040;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> n = new ArrayList();
		int[] m = new int[9];
		int l = 0;

		for (int i = 0; i < 9; i++) {
			int k = sc.nextInt();
			m[i] = k;
			l += k;
		}

		for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (l - (m[i] + m[j]) == 100) {
					n.add(m[i]);
					n.add(m[j]);
					break;
				}
			}
		}

		for (int i = 0; i < 9; i++) {
			if(!n.contains(m[i])){
				System.out.println(m[i]);
			}
		}
	}
}
