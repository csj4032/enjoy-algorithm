package levelTwo;

import java.util.*;

public class DefenseGame {

    public static class State {
        int n;
        int k;
        int index;

        public State(int n, int k, int index) {
            this.n = n;
            this.k = k;
            this.index = index;
        }

        @Override
        public String toString() {
            return "State{" +
                    "n=" + n +
                    ", k=" + k +
                    ", index=" + index +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            State state = (State) o;
            return n == state.n && k == state.k && index == state.index;
        }

        @Override
        public int hashCode() {
            return Objects.hash(n, k, index);
        }
    }

    public int solution(int n, int k, int[] enemy) {
        long sum = 0L;
        for (int j : enemy) sum += j;
        if (n >= sum) return enemy.length;
        if (k >= enemy.length) return enemy.length;
        return bfs(n, k, enemy);
    }

    private int bfs(int n, int k, int[] enemy) {
        Map<State, Integer> map = new HashMap<>();
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(n, k, 0));
        int result = 0;
        while (!queue.isEmpty()) {
            State state = queue.poll();
            if (map.containsKey(state)) continue;
            map.put(state, state.index);
            result = Math.max(result, state.index);
            if (enemy.length > state.index) {
                if (state.n - enemy[state.index] >= 0) {
                    queue.add(new State(state.n - enemy[state.index], state.k, state.index + 1));
                }
                if (state.k > 0) {
                    queue.add(new State(state.n, state.k - 1, state.index + 1));
                }
            }
        }
        return result;
    }

    private int dfs(int n, int k, int index, int[] enemy) {
        if (index >= enemy.length) return index;
        if (n < 0) return index;
        if (k <= 0) return index;
        int max1 = dfs(n - enemy[index], k, index + 1, enemy);
        int max2 = dfs(n, k - 1, index + 1, enemy);
        return Math.max(max1, max2);
    }
}
