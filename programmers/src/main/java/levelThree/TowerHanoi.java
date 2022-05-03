package levelThree;

import java.util.Arrays;

public class TowerHanoi {

	private int k = 0;

	public int[][] solution(int n) {
		int nn = (int) Math.pow(2, n) - 1;
		int[][] answer = new int[nn][2];
		hanoi(n, 1, 3, 2, answer);
		return answer;
	}

	private void hanoi(int n, int from, int to, int aux, int[][] answer) {
		if (n == 1) {
			answer[k] = new int[]{from, to};
			k++;
			return;
		}
		hanoi(n - 1, from, aux, to, answer);
		answer[k] = new int[]{from, to};
		k++;
		hanoi(n - 1, aux, to, from, answer);
	}

	public static void main(String[] args) {
		TowerHanoi towerHanoi = new TowerHanoi();
		System.out.println(Arrays.deepToString(towerHanoi.solution(2)));;
	}
}