package levelThree;

import java.util.*;

public class FarthestNode {
    public int solution(int n, int[][] edge) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> distances = new HashMap<>();

        for (int i = 1; i <= n; i++) graph.put(i, new ArrayList<>());

        for (int[] node : edge) {
            graph.get(node[0]).add(node[1]);
            graph.get(node[1]).add(node[0]);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0});
        distances.put(1, 0);
        Integer max = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int distance = current[1];
            max = Math.max(max, distance);
            for (int neighbor : graph.get(node)) {
                if (distances.containsKey(neighbor)) continue;
                queue.add(new int[]{neighbor, distance + 1});
                distances.put(neighbor, distance + 1);
            }
        }

        int answer = 0;
        for (Map.Entry<Integer, Integer> entry : distances.entrySet()) {
            if (entry.getValue().equals(max)) answer++;
        }

        return answer;
    }
}
