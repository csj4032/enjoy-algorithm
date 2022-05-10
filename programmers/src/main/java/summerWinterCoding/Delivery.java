package summerWinterCoding;

import java.util.*;

public class Delivery {

	PriorityQueue<Vertex> queue = new PriorityQueue<>();
	private List<List<Vertex>> graphs = new ArrayList();
	static int[] distances;

	public int likelihood(int N, int[][] road, int K) {
		distances = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			graphs.add(new ArrayList<>());
			distances[i] = 1000000;
		}

		for (int i = 0; i < road.length; i++) {
			int a = road[i][0];
			int b = road[i][1];
			int d = road[i][2];
			graphs.get(a).add(new Vertex(b, d));
			graphs.get(b).add(new Vertex(a, d));
		}

		distances[1] = 0;
		queue.add(new Vertex(1, 0));

		while (!queue.isEmpty()) {
			Vertex cur = queue.poll();
			if(distances[cur.v] < cur.w) continue;
			for (Vertex next : graphs.get(cur.v)) {
				if ((distances[cur.v] + next.w) < distances[next.v]) {
					distances[next.v] = distances[cur.v] + next.w;
					queue.offer(new Vertex(next.v, distances[next.v]));
				}
			}
		}

		int count = 0;
		for (int i = 0; i <= N; i++) {
			if (distances[i] <= K) {
				count++;
			}
		}
		return count;
	}
}

class Vertex implements Comparable<Vertex> {
	Integer v;
	Integer w;

	public Vertex(Integer v, Integer w) {
		this.v = v;
		this.w = w;
	}

	@Override
	public int compareTo(Vertex o) {
		return (this.w < o.w) ? -1 : ((this.w == o.w) ? 0 : 1);
	}

	@Override
	public String toString() {
		return "Tuple{" + "v=" + v + ", w=" + w + '}';
	}
}

