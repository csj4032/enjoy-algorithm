package levelThree;

import java.util.*;

/**
 * Link : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/132266">부대복귀</a>
 * Category : 그래프 이론
 */
public class ReturnBase {

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            graph.get(road[0] - 1).add(road[1]);
            graph.get(road[1] - 1).add(road[0]);
        }

        for (int i = 0; i < sources[i]; i++) {
            bfs(graph, sources[i], destination);
        }
        return answer;
    }

    public static void bfs(List<List<Integer>> graph, int source, int destination) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(destination);
        int count = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            count++;
            for (int i = 0; i < graph.get(current - 1).size(); i++) {
                int next = graph.get(current - 1).get(i);
                if (next == destination) {
                    return;
                }
                queue.add(next);
                graph.get(next - 1).remove(Integer.valueOf(current));
            }
        }
    }
}
