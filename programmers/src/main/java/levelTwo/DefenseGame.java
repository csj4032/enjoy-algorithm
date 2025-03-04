package levelTwo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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
    }

    public int solution(int n, int k, int[] enemy) {
        if (k >= enemy.length) return enemy.length;
        return bfs(n, k, 0, enemy);
    }

    private int bfs(int n, int k, int index, int[] enemy) {
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(n, k, index));
        int result = 0;
        while (!queue.isEmpty()) {
            State state = queue.poll();
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
