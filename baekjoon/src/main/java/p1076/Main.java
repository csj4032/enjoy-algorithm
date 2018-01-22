package p1076;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	static Map<String, Resistance> map = new HashMap<>();

	static {
		map.put("black", new Resistance("black", "0", 1L));
		map.put("brown", new Resistance("brown", "1", 10L));
		map.put("red", new Resistance("red", "2", 100L));
		map.put("orange", new Resistance("orange", "3", 1000L));
		map.put("yellow", new Resistance("yellow", "4", 10000L));
		map.put("green", new Resistance("green", "5", 100000L));
		map.put("blue", new Resistance("blue", "6", 1000000L));
		map.put("violet", new Resistance("violet", "7", 10000000L));
		map.put("grey", new Resistance("grey", "8", 100000000L));
		map.put("white", new Resistance("white", "9", 1000000000L));
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String value = map.get(sc.next()).value + map.get(sc.next()).value;
		Long multiplication = Long.valueOf(value) * map.get(sc.next()).multiplication;
		System.out.println(multiplication);
	}
}

class Resistance {
	String color;
	String value;
	Long multiplication;

	public Resistance(String color, String value, Long multiplication) {
		this.color = color;
		this.value = value;
		this.multiplication = multiplication;
	}
}
