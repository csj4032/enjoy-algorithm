package levelTwo;

import java.util.HashSet;
import java.util.Set;

public class WordChainGame {

    public int[] solution(int n, String[] words) {
        Set<String> wordSet = new HashSet<>();
        wordSet.add(words[0]);
        char expected = words[0].charAt(words[0].length() - 1);
        for (int i = 1; i < words.length; i++) {
            String currentWord = words[i];
            if (currentWord.charAt(0) != expected || !wordSet.add(words[i])) {
                return new int[]{(i % n) + 1, (i / n) + 1};
            }
            expected = currentWord.charAt(currentWord.length() - 1);
        }
        return new int[]{0, 0};
    }
}
