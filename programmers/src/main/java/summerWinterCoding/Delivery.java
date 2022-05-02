package summerWinterCoding;

import java.util.*;

public class Delivery {

	private List<Vertex>[] graphs;
	private boolean[] visitors;

	public int likelihood(int N, int[][] road, int K) {
		graphs = new ArrayList[N];
		visitors = new boolean[N];
		PriorityQueue<Vertex> queue = new PriorityQueue<>();

		for (int i = 0; i < N; i++) graphs[i] = new ArrayList<>();
		for (int i = 0; i < road.length; i++) {
			int a = road[i][0] - 1;
			int b = road[i][1] - 1;
			int d = road[i][2];
			graphs[a].add(new Vertex(b, d));
		}

		Vertex[] distances = new Vertex[N];
		for (int i = 0; i < N; i++) {
			if(i == 0) distances[i] = new Vertex(i, 0);
			distances[i] = new Vertex(i, Integer.MAX_VALUE);
			queue.add(distances[i]);
		}

		while (!queue.isEmpty()) {
			Vertex vertex = queue.poll();
			for (Vertex v : graphs[vertex.index]){
				distances[v.index].distance = distances[vertex.index].distance + v.distance;
				queue.offer(new Vertex(v.index, distances[v.index].distance));
			}
		}

		int count = 0;
		return count;
	}
}

class Vertex implements Comparable<Vertex> {
	Integer index;
	Integer distance;

	public Vertex(Integer index, Integer distance) {
		this.index = index;
		this.distance = distance;
	}

	@Override
	public int compareTo(Vertex vertex) {
		return this.distance.compareTo(vertex.distance);
	}

	@Override
	public String toString() {
		return "Vertex{" +
				"index=" + index +
				", distance=" + distance +
				'}';
	}
}

