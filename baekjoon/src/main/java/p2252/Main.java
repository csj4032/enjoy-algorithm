package p2252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 제목 : 줄 세우기
 * 링크 : https://www.acmicpc.net/problem/2252
 * 분류 : 위상 정렬, 우선 순위 큐
 */
public class Main {

    static List<List<Integer>> graph;
    static List<Integer> order;
    static LinkedList<Integer> queue;
    static LinkedList<Integer> result;
    static int[] count;
    private static Integer n;
    private static Integer m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());
        order = new ArrayList<>();
        graph = new ArrayList<>();
        result = new LinkedList<>();
        queue = new LinkedList<>();
        count = new int[n + 1];

        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            order.add(a);
            count[b]++;
        }
        topologicalSort();
        while (!result.isEmpty()) System.out.print(result.poll() + " ");
    }

    private static void topologicalSort() {
        for (int i = 1; i <= n; i++) {
            if (count[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()){
            int h = queue.poll();
            result.offer(h);
            for (int v : graph.get(h)) {
                count[v]--;
                if (count[v] == 0) queue.offer(v);
            }
        }
    }
}