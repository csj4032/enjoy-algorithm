package p2568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	static int[] lis;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		var n = Integer.parseInt(br.readLine());
		boolean[] visited = new boolean[51];
		Pair[] arr = new Pair[n];
		Pair[] trace = new Pair[n];
		lis = new int[n];

		for (int i = 0; i < n; i++) {
			String[] temp = br.readLine().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			arr[i] = new Pair(a, b);
			visited[a] = true;
		}

		Arrays.sort(arr);

		int idx = 0;
		lis[idx] = arr[0].r;
		trace[0] = new Pair(0, arr[0].l);

		for (int i = 1; i < n; i++) {
			if (lis[idx] < arr[i].r) {
				lis[++idx] = arr[i].r;
				trace[i] = new Pair(idx, arr[i].l);
			} else {
				int lower_bound = binarySearch(0, idx, arr[i].r);
				System.out.println(idx + " " + arr[i].r + " " + lower_bound);
				lis[lower_bound - 1] = arr[i].r;
				trace[i] = new Pair(lower_bound - 1, arr[i].l);
			}
		}

		List<Integer> list = new ArrayList<>();
		for (int i = n - 1; i >= 0; i--) {
			if (trace[i].l == idx) {
				list.add(trace[i].r);
				idx--;
			}
		}


		for (int a : list)
			visited[a] = false;


		for (int i = 0; i <= 500000; i++) {
			//if (visited[i]) System.out.println(i);
		}
	}

	private static int binarySearch(int left, int right, int v) {
		while (left < right) {
			int mid = (left + right) / 2;
			if (lis[mid] >= v)
				right = mid;
			else
				left = mid + 1;
		}

		return right + 1;
	}
}

class Pair implements Comparable<Pair> {
	int l;
	int r;

	Pair(int l, int r) {
		this.l = l;
		this.r = r;
	}

	@Override
	public int compareTo(Pair a) {
		if (this.l < a.l)
			return -1;
		else if (this.l > a.l)
			return 1;
		return 0;
	}

	@Override
	public String toString() {
		return "Pair{" +
				"l=" + l +
				", r=" + r +
				'}';
	}
}