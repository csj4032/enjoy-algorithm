package p15353;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var a = new BigInteger(sc.next());
		var b = new BigInteger(sc.next());
		var c = a.add(b);
		System.out.println(c.toString());
	}
}