package levelTwo;

import java.util.*;

/**
 * Link : https://school.programmers.co.kr/learn/courses/30/lessons/250136
 * Category : DFS/BFS
 */
public class OilDrilling {

    class UnionFind {
        public int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        public int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        public int union(int x, int y) {
            x = find(x);
            y = find(y);
            if (x != y) parent[y] = x;
            return x;
        }
    }

    private int[][] directions = {{0, 1}, {1, 0}};

    public int solution(int[][] land) {
        int answer = 0;
        int row = land.length;
        int col = land[0].length;
        UnionFind uf = new UnionFind(row * col);
        int[] checker = new int[row * col];

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (land[j][i] == 0) continue;
                int current = j * col + i;
                checker[current] = 1;
                for (int k = 0; k < 2; k++) {
                    int ny = j + directions[k][0];
                    int nx = i + directions[k][1];
                    if (ny < row && nx < col && land[ny][nx] == 1) {
                        int next = ny * col + nx;
                        int rootCurrent = uf.find(current);
                        int rootNext = uf.find(next);
                        if (rootCurrent != rootNext) {
                            int root = uf.union(rootCurrent, rootNext);
                            checker[root] = checker[rootCurrent] + (checker[rootNext] == 0 ? 1 : checker[rootNext]);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < col; i++) {
            int count = 0;
            Set<Integer> chunkSet = new HashSet<>();
            for (int j = 0; j < row; j++) {
                if (land[j][i] == 0) continue;
                int current = j * col + i;
                chunkSet.add(uf.find(current));
            }
            for (Integer chuck : chunkSet) count += checker[chuck];
            answer = Math.max(answer, count);
        }
        return answer;
    }
}
