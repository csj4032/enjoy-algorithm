package com.genius.apss.chap08;

public class WildCard {

	private boolean match(String w, String s) {
		int pos = 0;
		while (pos < s.length() && pos < w.length() && (w.charAt(pos) == '?' || w.charAt(pos) == s.charAt(pos))) {
			pos++;
		}
		if (pos == w.length()) return pos == s.length();

		if (w.charAt(pos) == '*') {
			for (int i = 0; i + pos <= s.length(); i++) {
				if (match(w.substring(pos + 1), s.substring(pos + i))) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		WildCard wildCard = new WildCard();
		System.out.println(wildCard.match("*a", "help"));
	}
}
