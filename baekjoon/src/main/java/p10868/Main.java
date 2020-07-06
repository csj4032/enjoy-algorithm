package p10868;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 제목 : 최솟값
 * 링크 : https://www.acmicpc.net/problem/10868
 * 분류 : 세그먼트 트리
 */
public class Main {

	static int[] tree;
	static int[] arr;
	static int n;
	static int m;
	static int k;

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		k = (int)Math.ceil(Math.log(n) / Math.log(2));
		arr = new int[n];
		tree = new int[1 << (k + 1)];
		for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
		init(0, n - 1, 1);
		for (int i = 0; i < m; i++) {
			int l = sc.nextInt();
			int r = sc.nextInt();
			int min = query(0, n - 1, l - 1, r - 1, 1);
			System.out.println(min);
		}
	}

	private static int init(int s, int e, int node) {
		if (s == e) return tree[node] = arr[s];
		var mid = (s + e) / 2;
		return tree[node] = Math.min(init(s, mid, node * 2), init(mid + 1, e, node * 2 + 1));
	}

	private static int query(int s, int e, int l, int r, int node) {
		if (s > r || e < l) return Integer.MAX_VALUE;
		if (s >= l && e <= r) return tree[node];
		var mid = (s + e) / 2;
		return Math.min(query(s, mid, l, r, node * 2), query(mid + 1, e, l, r, node * 2 + 1));
	}
}

class InputReader {
	private InputStream stream;
	private byte[] buf = new byte[1024];
	private int curChar;
	private int numChars;

	public InputReader(InputStream stream) {
		this.stream = stream;
	}

	public int read() {
		if (numChars == -1) {
			throw new InputMismatchException();
		} else {
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException var2) {
					throw new InputMismatchException();
				}
				if (numChars <= 0) {
					return -1;
				}
			}
			return buf[curChar++];
		}
	}

	public boolean isSpace(int c) {
		return c == 10 || c == 13 || c == -1 || c == 9 || c == 32;
	}

	private boolean isEnd(int c) {
		return c == 10 || c == 13 || c == -1;
	}

	public String next() {
		int c = this.read();
		while (isSpace(c)) {
			c = this.read();
		}
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
		} while (!isSpace(c = this.read()));
		return res.toString();
	}

	public int nextInt() {
		int c = this.read();
		while (isSpace(c)) {
			c = this.read();
		}
		byte sgn = 1;
		if (c == 45) {
			sgn = -1;
			c = this.read();
		}
		int res = 0;
		while (c >= 48 && c <= 57) {
			res *= 10;
			res += c - 48;
			c = this.read();
			if (isSpace(c)) {
				return res * sgn;
			}
		}
		throw new InputMismatchException();
	}

	public long nextLong() {
		int c = this.read();
		while (isSpace(c)) {
			c = this.read();
		}
		byte sgn = 1;
		if (c == 45) {
			sgn = -1;
			c = this.read();
		}
		long res = 0;
		while (c >= 48 && c <= 57) {
			res *= 10;
			res += c - 48;
			c = this.read();
			if (isSpace(c)) {
				return res * sgn;
			}
		}
		throw new InputMismatchException();
	}

	public String nextLine() {
		int c = read();
		while (isEnd(c)) {
			c = this.read();
		}
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
		} while (!isEnd(c = this.read()));
		return res.toString();
	}

}

class OutputWriter {
	private final PrintWriter writer;

	public OutputWriter(OutputStream outputStream) {
		writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
	}

	public OutputWriter(Writer writer) {
		this.writer = new PrintWriter(writer);
	}

	public void print(char c) {
		writer.print(c);
	}

	public void print(int i) {
		writer.print(i);
	}

	public void print(long l) {
		writer.print(l);
	}

	public void print(double d) {
		writer.print(d);
	}

	public void print(Object... objects) {
		int len = objects.length;
		for (int i = 0; i < len; i++) {
			writer.print(objects[i]);
		}
	}

	public void println() {
		writer.println();
	}

	public void close() {
		writer.close();
	}
}