package p10868;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 백준 10868번: 최솟값 (Gold 1)
 * https://www.acmicpc.net/problem/10868
 * 
 * == 문제 분류 ==
 * 자료 구조, 세그먼트 트리, RMQ
 * 
 * == 알고리즘 이론 ==
 * 1. RMQ (Range Minimum Query)
 *    - 구간 최솟값 쿼리 문제
 *    - 배열의 특정 구간 [l, r]에서 최솟값 찾기
 *    - 세그먼트 트리로 O(log n) 시간에 해결
 * 
 * 2. 세그먼트 트리 (Min Segment Tree)
 *    - 각 노드는 해당 구간의 최솟값 저장
 *    - 리프 노드: 원본 배열의 값
 *    - 내부 노드: 자식들 중 최솟값
 * 
 * 3. 대안 알고리즘들
 *    - Sparse Table: O(n log n) 전처리, O(1) 쿼리
 *    - Square Root Decomposition: O(√n) 쿼리
 *    - 단순 반복문: O(n) 쿼리
 * 
 * == 핵심 아이디어 ==
 * 1. 트리 구성: tree[node] = min(tree[2*node], tree[2*node+1])
 * 2. 쿼리 처리: 구간을 재귀적으로 분할하여 탐색
 * 3. 경계 처리: 쿼리 구간과 노드 구간의 관계
 * 4. 무한값 반환: 범위를 벗어난 경우 Integer.MAX_VALUE
 * 
 * == 시간복잡도 ==
 * - 초기화: O(n)
 * - 구간 쿼리: O(log n)
 * - 전체: O(n + m log n)
 * 
 * == 공간복잡도 ==
 * O(4n) - 세그먼트 트리 배열
 * 
 * == 구현 최적화 기법 ==
 * 1. 트리 크기 계산: 2^(ceil(log2(n))+1)
 * 2. 1-based 인덱싱으로 자식 노드 접근 용이
 * 3. 재귀 깊이 최적화
 * 4. 메모리 정렬로 캐시 효율성 향상
 * 
 * == 업데이트 없는 특성 ==
 * - 이 문제는 쿼리만 있고 업데이트 없음
 * - Sparse Table이 더 효율적일 수 있음
 * - 하지만 세그먼트 트리가 더 일반적이고 확장 가능
 * 
 * == 실무 응용 ==
 * - 시계열 데이터의 최솟값 모니터링
 * - 센서 네트워크에서 최소 측정값 찾기
 * - 재고 관리 시스템의 최소 재고량 추적
 * - 네트워크 지연시간 최솟값 계산
 * 
 * == 관련 심화 문제 ==
 * - 백준 2357: 최솟값과 최댓값 (Min/Max 세그먼트 트리)
 * - 백준 2268: 수들의 합 7 (업데이트 포함)
 * - 백준 1275: 커피숍2 (구간 합 + 업데이트)
 * - 백준 11505: 구간 곱 구하기 (곱셈 세그먼트 트리)
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