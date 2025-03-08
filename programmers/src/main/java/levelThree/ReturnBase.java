package levelThree;

import java.util.*;

/**
 * Link : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/132266">부대복귀</a>
 * Category : Graph, BFS, Dijkstra
 */
public class ReturnBase {

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] road : roads) {
            graph.get(road[0] - 1).add(road[1] - 1);
            graph.get(road[1] - 1).add(road[0] - 1);
        }

        int[] distance = new int[n];
        Arrays.fill(distance, -1);
        distance[destination - 1] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(destination - 1);

        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            for (int neighbor : graph.get(current)) {
                if (distance[neighbor] == -1) {
                    distance[neighbor] = distance[current] + 1;
                    queue.add(neighbor);
                }
            }
        }

        for (int i = 0; i < sources.length; i++) answer[i] = distance[sources[i] - 1];

        System.out.println(Arrays.toString(answer));
        return answer;
    }
}
