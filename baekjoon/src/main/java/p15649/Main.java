package p15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * 제목 : N과 M (1)
 * 링크 : https://www.acmicpc.net/problem/15649
 * 분류 : 조합(nCr), 순열(nPr), DFS
 */
public class Main {

	static StringBuilder sb;
	private static final int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8};
	private static final List<String> strings = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		sb = new StringBuilder();
		permutation(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
		strings.sort(Comparator.naturalOrder());
		strings.forEach(System.out::println);

		int[] comArrays = new int[4];
		combination(comArrays, numbers.length, 4, 0, 0, numbers);
	}

	private static void permutation(int n, int m, int depth) {
		if (depth == m) {
			strings.add(Arrays.stream(numbers).limit(m).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
			return;
		}
		for (int i = depth; i < n; i++) {
			swap(i, depth);
			permutation(n, m, depth + 1);
			swap(i, depth);
		}
	}

	private static void swap(int p, int q) {
		int t = numbers[p];
		numbers[p] = numbers[q];
		numbers[q] = t;
	}

	private static void combination(int[] combArr, int n, int r, int index, int target, int[] arr) {
		if (r == 0) {
			for (int i = 0; i < index; i++) {
				System.out.print(arr[combArr[i]] + " ");
			}
			System.out.println();
		} else if (target == n) {
			return;
		} else {
			combArr[index] = target;
			combination(combArr, n, r - 1, index + 1, target + 1, arr);
			combination(combArr, n, r, index, target + 1, arr);
		}
	}
}