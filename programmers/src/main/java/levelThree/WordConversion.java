package levelThree;

public class WordConversion {

    private static int min = Integer.MAX_VALUE;

    public int solution(String begin, String target, String[] words) {
        boolean targetExists = false;
        for (int i = 0; i < words.length; i++) if (words[i].equals(target)) targetExists = true;
        if (!targetExists) return 0;
        dfs(begin, target, 0, new boolean[words.length], words);
        return min;
    }

    public void dfs(String current, String target, int depth, boolean[] visited, String[] words) {
        if (current.equals(target)) {
            min = Math.min(min, depth);
            return;
        }

        if (depth >= min) return;

        for (int i = 0; i < words.length; i++) {
            if (isOnlyOneAlphabetDifferent(current, words[i]) && !visited[i]) {
                visited[i] = true;
                dfs(words[i], target, depth + 1, visited, words);
                visited[i] = false;
            }
        }
    }

    public static boolean isOnlyOneAlphabetDifferent(String str1, String str2) {
        int diffCount = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                diffCount++;
                if (diffCount > 1) return false;
            }
        }
        return diffCount == 1;
    }
}
