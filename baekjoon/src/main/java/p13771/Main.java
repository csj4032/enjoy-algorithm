package p13771;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var m = new ArrayList<Double>();
		for (int i = 0; i < n; i++) {
			m.add(sc.nextDouble());
		}
		Collections.sort(m);
		System.out.printf("%.2f", m.get(1));
	}
}
