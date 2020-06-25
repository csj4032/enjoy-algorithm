package p1000;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

public class Main2 {

	static int[] lis;
	static Wire[] list;
	static Pair[] trace;
	static boolean[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		list = new Wire[N];
		lis = new int[N];
		visit = new boolean[11];
		Vector<Integer> v = new Vector<>();
		trace = new Pair[11];
		for (int i = 0; i < 11; i++) {
			trace[i] = new Pair();
		}
		for (int i = 0; i < N; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			list[i] = new Wire(s, e);
			visit[s] = true;
		}
		Arrays.sort(list);

		int pLis = 0, pArr = 1;

		lis[pLis] = list[0].b;
		trace[0].first = 0;
		trace[0].second = list[0].a;

		System.out.println(Arrays.toString(list));
		System.out.println(" ");
		System.out.println(Arrays.toString(lis));
		System.out.println(Arrays.toString(trace));
		System.out.println(" ");
		while (pArr < N) {
			if (lis[pLis] < list[pArr].b) {
				lis[++pLis] = list[pArr].b;
				trace[pArr].first = pLis;
				trace[pArr].second = list[pArr].a;
			} else {
				int ans = lowerBound(0, pLis, list[pArr].b);
				lis[ans - 1] = list[pArr].b;
				trace[pArr].first = ans - 1;
				trace[pArr].second = list[pArr].a;
			}
			pArr++;
			System.out.println(Arrays.toString(lis) + " " + pLis);
			System.out.println(Arrays.toString(trace));
			System.out.println("");
		}
		//System.out.println(Arrays.toString(trace));
		System.out.println(N - (pLis + 1));

		int p = pLis;
		Stack<Integer> st = new Stack<>();
		for (int i = N - 1; i >= 0; i--) {
			if (trace[i].first == p) {
				st.push(trace[i].second);
				p--;
			}
		}
		System.out.println("st : "+ st);
	}

	public static int lowerBound(int start, int end, int target) {
		int mid;
		while (start < end) {
			mid = (start + end) / 2;
			if (lis[mid] < target)
				start = mid + 1;
			else
				end = mid;
		}
		return end + 1;
	}
}

class Wire implements Comparable<Wire> {
	int a;
	int b;

	Wire(int a, int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public int compareTo(Wire o) {
		return this.a < o.a ? -1 : 1;
	}

	@Override
	public String toString() {
		return "Wire{" +
				"a=" + a +
				", b=" + b +
				'}';
	}
}

class Pair {
	int first, second;

	public Pair(int first, int second) {
		this.first = first;
		this.second = second;
	}

	public Pair() {
	}

	@Override
	public String toString() {
		return "Pair{" +
				"first=" + first +
				", second=" + second +
				'}';
	}
}