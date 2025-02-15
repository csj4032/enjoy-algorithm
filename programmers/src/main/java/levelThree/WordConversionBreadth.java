package levelThree;

import java.util.LinkedList;
import java.util.Queue;

import static levelThree.WordConversion.isOnlyOneAlphabetDifferent;

public class WordConversionBreadth {

    private static class WordNode {
        String word;
        int steps;

        WordNode(String word, int steps) {
            this.word = word;
            this.steps = steps;
        }
    }

    public int solution(String begin, String target, String[] words) {
        boolean targetExists = false;
        for (int i = 0; i < words.length; i++) if (words[i].equals(target)) targetExists = true;
        if (!targetExists) return 0;
        boolean[] visited = new boolean[words.length];
        Queue<WordNode> queue = new LinkedList<>();
        queue.add(new WordNode(begin, 0));

        while (!queue.isEmpty()) {
            WordNode current = queue.poll();
            if (current.word.equals(target)) return current.steps;
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && isOnlyOneAlphabetDifferent(current.word, words[i])) {
                    visited[i] = true;
                    queue.add(new WordNode(words[i], current.steps + 1));
                }
            }
        }
        return 0;
    }
}
