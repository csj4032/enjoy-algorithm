package levelTwo;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/86971
 */
public class DividingPower {

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < wires.length; i++) {
            Map<Integer, List<Integer>> graph = new HashMap();
            for (int j = 0; j < wires.length; j++) {
                if (i == j) continue;
                Integer node1 = wires[j][0];
                Integer node2 = wires[j][1];
                graph.putIfAbsent(node1, new ArrayList<>());
                graph.putIfAbsent(node2, new ArrayList<>());
                graph.get(node1).add(node2);
                graph.get(node2).add(node1);
            }
            int count = dfs(graph, 1);
            int difference = Math.abs((n - count) - count);
            answer = Math.min(answer, difference);
        }

        return answer;
    }

    public Integer dfs(Map<Integer, List<Integer>> graph, Integer start) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        stack.push(start);
        int count = 0;
        while (!stack.isEmpty()) {
            Integer node = stack.pop();
            count++;
            for (Integer neighbor : graph.getOrDefault(node, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    stack.push(neighbor);
                }
            }
        }
        return count;
    }
}
