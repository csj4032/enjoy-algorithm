package p10936;

import java.util.Base64;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var s = sc.next();
		System.out.println(new String(Base64.getDecoder().decode(s.getBytes())));
	}
}
