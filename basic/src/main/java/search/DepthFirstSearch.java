package search;

public class DepthFirstSearch {
	private int n;
	private boolean graph[][];
	private boolean visits[];
	private StringBuilder visited;

	public DepthFirstSearch(int n) {
		this.n = n;
		this.graph = new boolean[n][n];
		this.visits = new boolean[n];
		this.visited = new StringBuilder("dfs = ");
	}

	private void dfs(int v) {
		if(visits[v]) return;
		visits[v] = true;
		visited.append(v + " ");
		for (int i = 0; i < n; i++) {
			if (graph[v][i] == true && visits[i] == false) {
				dfs(i);
			}
		}
	}

	public void dfs() {
		for (int i = 0; i < n; i++) {
			visited = new StringBuilder();
			dfs(i);
			System.out.println(visited.toString());
		}
	}

	public static void main(String[] args) {
		DepthFirstSearch dfs = new DepthFirstSearch(4);
		dfs.dfs();
	}
}