package tree;

import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 참고
 * 1. https://www.acmicpc.net/blog/view/9
 * 2. https://m.blog.naver.com/kks227/220791986409
 */
public class SegmentTree {

	static int[] tree;

	public static int init(int[] array, int[] tree, int node, int start, int end) {
		if (start == end) {
			return tree[node] = array[start];
		} else {
			return tree[node] = init(array, tree, node * 2, start, (start + end) / 2) + init(array, tree, node * 2 + 1, (start + end) / 2 + 1, end);
		}
	}

	public static int sum(int[] tree, int node, int start, int end, int left, int right) {
		if (left > end || right < start) {
			return 0;
		}
		if (start >= left && end <= right) {
			return tree[node];
		}
		return sum(tree, node * 2, start, (start + end) / 2, left, right) + sum(tree, node * 2 + 1, (start + end) / 2 + 1, end, left, right);
	}

	public static double baseLog(double x, double base) {
		return Math.log10(x) / Math.log10(base);
	}

	public static void main(String[] args) {
		int[] array = {10, 20, 30, 40};
		int h = (int) Math.ceil(baseLog(5, 2));
		int size = (1 << (h + 1));
		tree = new int[size];
		init(array, tree, 1, 0, 3);
		int sum = sum(tree, 1, 0, 3, 0, 2);
		System.out.println(sum);

		IntStream.generate(() -> 100).limit(10).forEach(System.out::println);
		Long summ = Stream.iterate(new BigInteger[]{BigInteger.ONE, BigInteger.ONE}, p -> new BigInteger[]{p[1], p[0].add(p[1])}).limit(100).mapToLong(p -> p[0].longValue()).sum();
		System.out.println(summ);
	}
}