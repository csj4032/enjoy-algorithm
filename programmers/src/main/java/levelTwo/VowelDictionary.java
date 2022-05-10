package levelTwo;

import java.util.*;
import java.util.stream.Collectors;

public class VowelDictionary {

	private static String[] vowels = new String[]{"A", "E", "I", "O", "U", ""};
	private static Set<String> wordSet = new HashSet<>();
	private static List<String> wordList = new ArrayList<>();
	private static List<String> list = new ArrayList<>();

	public int solution(String word) {
		String[] alphabet = new String[5];
		recursive(alphabet, 0);
		wordList = wordSet.stream().collect(Collectors.toList());
		Collections.sort(wordList);
		return wordList.indexOf(word);
	}

	private void recursive(String[] alphabet, int depth) {
		if (depth >= 5) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < alphabet.length; i++) {
				sb.append(alphabet[i]);
			}
			wordSet.add(sb.toString().trim());
			return;
		}

		for (int i = 0; i < 6; i++) {
			alphabet[depth] = vowels[i];
			recursive(alphabet, depth + 1);
		}
	}

	private void dfs(String str, int len) {
		if (len > 5) return;
		list.add(str);
		for (int i = 0; i < 5; i++) {
			dfs(str + "AEIOU".charAt(i), len + 1);
		}
	}
}
