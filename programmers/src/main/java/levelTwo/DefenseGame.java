package levelTwo;

import java.util.*;

public class DefenseGame {

    public static class State implements Comparable<State> {
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
            return "State{" + "n=" + n + ", k=" + k + ", index=" + index + '}';
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

        @Override
        public int compareTo(State o) {
            int result = Integer.compare(o.index, index);
            if (result == 0) {
                result = Integer.compare(k, o.k);
                if (result == 0) {
                    result = Integer.compare(n, o.n);
                }
            }
            return result;
        }
    }

    public int solution(int n, int k, int[] enemy) {
        long sum = 0;
        int index;
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (index = 0; index < enemy.length; index++) {
            sum += enemy[index];
            queue.add(enemy[index]);
            while (sum > n && k > 0) {
                k--;
                sum -= queue.poll();
            }
            if (sum > n) break;
        }
        return index;
    }

    private int bfs(State first, int[] enemy) {
        Map<State, Integer> map = new HashMap<>();
        Queue<State> queue = new PriorityQueue<>();
        queue.add(first);
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
            System.out.println(state);
        }
        System.out.println();
        return result;
    }

    private int dfs(State state, int[] enemy, Map<State, Integer> map) {
        if (map.containsKey(state)) return state.index;
        if (state.index >= enemy.length) return enemy.length;
        if (state.n < 0) return state.index;
        if (state.k <= 0) return state.index;
        return Math.max(dfs(new State(state.n - enemy[state.index], state.k, state.index + 1), enemy, map), dfs(new State(state.n, state.k - 1, state.index + 1), enemy, map));
    }
}
