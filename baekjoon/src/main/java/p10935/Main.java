package p10935;

import java.util.Base64;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		System.out.println(new String(Base64.getEncoder().encode(sc.next().getBytes())));
	}
}