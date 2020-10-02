package p1753;

import java.io.*;
import java.util.*;

/**
 * 제목 : 최단경로
 * 링크 : https://www.acmicpc.net/problem/1753
 * 분류 : 그래프 이론, 다익스트라
 */
public class Main {

	static Queue<Tuple> queue = new PriorityQueue<>(2000001);
	static List<List<Tuple>> graph = new ArrayList<>(2000001);
	static int[] distance;
	static boolean[][] processed;
	static int max = 2000001;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] nn = br.readLine().split(" ");
		int v = Integer.parseInt(nn[0]);
		int e = Integer.parseInt(nn[1]);
		int s = Integer.parseInt(br.readLine());
		distance = new int[v + 1];
		processed = new boolean[v + 1][11];
		for (int i = 0; i <= v; i++) {
			distance[i] = max;
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < e; i++) {
			String[] nnn = br.readLine().split(" ");
			var u = Integer.parseInt(nnn[0]);
			var vv = Integer.parseInt(nnn[1]);
			var w = Integer.parseInt(nnn[2]);
			graph.get(u).add(new Tuple(vv, w));
		}
		dijkstra(s);

		for (int i = 1; i <= v; i++) {
			if (distance[i] == max) {
				bw.write("INF\n");
			} else {
				bw.write(distance[i] + "\n");
			}
		}
		bw.close();
	}

	private static void dijkstra(int s) {
		distance[s] = 0;
		queue.add(new Tuple(s, 0));
		while (!queue.isEmpty()) {
			var cur = queue.peek();
			queue.poll();
			if(distance[cur.v] < cur.w) continue;
			for (Tuple next : graph.get(cur.v)) {
				if ((distance[cur.v] + next.w) < distance[next.v]) {
					distance[next.v] = distance[cur.v] + next.w;
					queue.offer(new Tuple(next.v, distance[next.v]));
				}
			}
		}
	}
}

class Tuple implements Comparable<Tuple> {
	int v;
	int w;

	public Tuple(int v, int w) {
		this.v = v;
		this.w = w;
	}

	@Override
	public int compareTo(Tuple o) {
		return (this.w < o.w) ? -1 : ((this.w == o.w) ? 0 : 1);
	}

	@Override
	public String toString() {
		return "Tuple{" + "v=" + v + ", w=" + w + '}';
	}
}