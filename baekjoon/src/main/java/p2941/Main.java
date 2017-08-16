package p2941;

import java.util.*;

public class Main {

	private static List<String> words = new ArrayList<>();

	static {
		words.add("c=");
		words.add("c-");
		words.add("dz=");
		words.add("d-");
		words.add("lj");
		words.add("nj");
		words.add("s=");
		words.add("z=");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		Integer len = str.length();
		for (int i = 0; i < words.size(); i++) {
			String word = words.get(i);
			for (int j = 0; j < str.length() - (word.length() - 1); j++) {
				if (str.substring(j, j + word.length()).equals(word)) {
					len = len - (word.length() - 1);
					if (word.equals("z=") && str.substring(j - 1, j + word.length()).equals("dz="))
						len = len + 1;
				}
			}
		}
		System.out.println(len);
		System.out.println(str.replaceAll("c=|c-|dz=|d-|lj|nj|s=|z="," ").length());
	}
}