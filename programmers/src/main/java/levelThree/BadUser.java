package levelThree;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BadUser {

    public int solution(String[] user_id, String[] banned_id) {
        Set<String> result = new HashSet<>();
        dfs(0, user_id, banned_id, new String[banned_id.length], new boolean[user_id.length], result);
        return result.size();
    }

    public static void dfs(int depth, String[] user_id, String[] banner_id, String[] target_id, boolean[] visited, Set<String> result) {
        if (depth == target_id.length) {
            int count = 0;
            for (int i = 0; i < banner_id.length; i++) {
                if (isMatch(banner_id[i], target_id[i])) count++;
            }
            if (count == banner_id.length) {
                String[] strings = target_id.clone();
                Arrays.sort(strings);
                result.add(Arrays.toString(strings));
            }
            return;
        }

        for (int i = 0; i < user_id.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                target_id[depth] = user_id[i];
                dfs(depth + 1, user_id, banner_id, target_id, visited, result);
                visited[i] = false;
            }
        }
    }

    private static boolean isMatch(String banned, String target) {
        if (banned.length() != target.length()) return false;
        for (int j = 0; j < banned.length(); j++) {
            if (banned.charAt(j) != '*' && banned.charAt(j) != target.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}

