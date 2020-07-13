package p1504;

import java.util.*;

public class Main {

	static PriorityQueue<Tuple> queue = new PriorityQueue<>();
	static List<List<Tuple>> graph = new ArrayList<>();
	static Map<Integer, Tuple> path = new HashMap();
	static int[] distance;
	static int max = 20000000;

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var node = sc.nextInt();
		var edge = sc.nextInt();
		var s = 1;
		distance = new int[node + 1];
		Arrays.fill(distance, max);
		for (int i = 0; i <= node; i++) {
			graph.add(new ArrayList());
		}
		for (int i = 0; i < edge; i++) {
			var a = sc.nextInt();
			var b = sc.nextInt();
			var c = sc.nextInt();
			graph.get(a).add(new Tuple(b, c));
		}
		//System.out.println(graph);
		dijkstra(s);
		//System.out.println(Arrays.toString(distance));
		//System.out.println(path);
	}

	private static void dijkstra(int s) {
		var first = new Tuple(s, 0);
		distance[first.v] = first.w;
		queue.offer(first);
		path.put(1, first);
		while (!queue.isEmpty()) {
			var cur = queue.peek();
			queue.poll();
			if(distance[cur.v] < cur.w) continue;
			for (Tuple next : graph.get(cur.v)) {
				//if (distance[next.v] > distance[cur.v] + next.w) {
					distance[next.v] = distance[cur.v] + next.w;
					queue.offer(new Tuple(next.v, distance[next.v]));
					path.put(next.v, new Tuple(cur.v, distance[next.v]));
				//}
			}
			System.out.println(queue);
		}
	}
}

class Tuple implements Comparable<Tuple> {
	Integer v;
	Integer w;

	public Tuple(Integer v, Integer w) {
		this.v = v;
		this.w = w;
	}

	@Override
	public String toString() {
		return "Tuple{" + "v=" + v + ", w=" + w + '}';
	}

	@Override
	public int compareTo(Tuple o) {
		return this.w.compareTo(o.w);
	}
}
//5 8
//5
//5 2 4
//5 4 2
//4 2 1
//4 3 1
//2 1 3
//1 4 3
//1 3 6
//3 4 2