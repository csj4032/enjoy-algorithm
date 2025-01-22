package levelTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fatigue {

    static boolean[] visited;
    static List<List<Integer>> request;

    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        int len = dungeons.length;
        visited = new boolean[dungeons.length];
        request = new ArrayList<>();
        permutation(len, 0, new ArrayList<>());
        for (List<Integer> subset : request) {
            int count = 0;
            int t = k;
            for (Integer index : subset) {
                int a = dungeons[index][0];
                int b = dungeons[index][1];
                if (a > t) break;
                t = t - b;
                count++;

            }
            answer = Math.max(answer, count);
        }
        return answer;
    }

    public void permutation(int limit, int depth, List<Integer> seq) {
        if (seq.size() == limit) {
            request.add(new ArrayList<>(seq));
            System.out.println(seq);
            return;
        }
        for (int i = 0; i < limit; i++) {
            if (!visited[i]) {
                visited[i] = true;
                seq.add(i);
                System.out.println("전 " + i + " " + depth + " " + Arrays.toString(visited));
                permutation(limit, ++depth, seq);
                visited[i] = false;
                System.out.println("후 " + i + " " + depth + " " + Arrays.toString(visited));
                seq.remove(seq.size() - 1);
            }
        }
    }
}
