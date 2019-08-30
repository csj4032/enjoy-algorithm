package dbfs;

public class Network {

    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited, computers);
                answer++;
            }
        }
        return answer;
    }

    public void dfs(int v, boolean[] visited, int[][] computers) {
        if(visited[v]) return;
        visited[v] = true;
        for (int i = 0; i < computers.length; i++) {
            if ((computers[v][i] == 1 || computers[i][v] == 1) && visited[i] == false) {
                dfs(i, visited, computers);
            }
        }
    }
}
