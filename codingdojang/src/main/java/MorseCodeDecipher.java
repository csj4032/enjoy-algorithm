import java.util.*;

import static java.lang.System.in;

public class MorseCodeDecipher {

	static Map<String, String> code = new HashMap<>();

	static {
		code.put("", " ");
		code.put(".-", "a");
		code.put("-...", "b");
		code.put("-.-.", "c");
		code.put("-..", "d");
		code.put(".", "e");
		code.put("..-.", "f");
		code.put("--.", "g");
		code.put("....", "h");
		code.put("..", "i");
		code.put(".---", "j");
		code.put("-.-", "k");
		code.put(".-..", "l");
		code.put("..-.", "m");
		code.put("-.", "n");
		code.put("---", "o");
		code.put(".--.", "p");
		code.put("--.-", "q");
		code.put(".-.", "r");
		code.put("...", "s");
		code.put("..-.", "t");
		code.put("..-", "u");
		code.put("...-", "v");
		code.put(".--", "w");
		code.put("-..-", "x");
		code.put("-.--", "y");
		code.put("--..", "z");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(in);
		List l = Arrays.asList(sc.nextLine().split(" "));
		System.out.println(l);
		l.stream().forEach(i -> System.out.print(code.get(i)));
	}
}