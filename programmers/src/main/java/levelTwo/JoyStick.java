package levelTwo;

import java.util.HashMap;
import java.util.Map;

public class JoyStick {

	static Map<String, Integer> alphabet = new HashMap<>();

	static {
		alphabet.put("A", 0);
		alphabet.put("B", 1);
		alphabet.put("C", 2);
		alphabet.put("D", 3);
		alphabet.put("E", 4);
		alphabet.put("F", 5);
		alphabet.put("G", 6);
		alphabet.put("H", 7);
		alphabet.put("I", 8);
		alphabet.put("J", 9);
		alphabet.put("K", 10);
		alphabet.put("L", 11);
		alphabet.put("M", 12);
		alphabet.put("N", 13);
		alphabet.put("O", 12);
		alphabet.put("P", 11);
		alphabet.put("Q", 10);
		alphabet.put("R", 9);
		alphabet.put("S", 8);
		alphabet.put("T", 7);
		alphabet.put("U", 6);
		alphabet.put("V", 5);
		alphabet.put("W", 4);
		alphabet.put("X", 3);
		alphabet.put("Y", 2);
		alphabet.put("Z", 1);
	}

	public int solution(String name) {
		int answer = 0;
		System.out.println(recursive(0, name.length()));
		return answer;
	}

	private int recursive(int i, int n) {
		if (i > n) return i;
		return recursive(i + 1, n) + recursive(i + 2, n);
	}
}


