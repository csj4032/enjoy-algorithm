package p5622;

import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

	private static Map<String, Integer> dial = new ConcurrentHashMap<>();

	static {
		dial.put("ABC", 3);
		dial.put("DEF", 4);
		dial.put("GHI", 5);
		dial.put("JKL", 6);
		dial.put("MNO", 7);
		dial.put("PQRS", 8);
		dial.put("TUV", 9);
		dial.put("WXYZ", 10);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] alphabets = sc.next().split("");
		Integer sum = 0;
		for (int i = 0; i < alphabets.length; i++) {
			String alphabet = alphabets[i];
			sum += dial.get(dial.keySet().stream().filter(e-> e.contains(alphabet)).findFirst().get());
		}
		System.out.println(sum);
	}
}