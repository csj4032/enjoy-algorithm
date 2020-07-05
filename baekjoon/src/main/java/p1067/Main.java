package p1067;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 제목 : A+B
 * 링크 : https://www.acmicpc.net/problem/1067
 * 분류 : Fast Fourier Transform, FFT 합성곱(convolution), 이산 합성곱(discrete convolution)
 */
public class Main {

	private static int n;
	private static long[] nn;
	private static String[] x;
	private static String[] y;
	private static long[] nnn;
	private static Deque<Long> deque;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		x = br.readLine().split(" ");
		y = br.readLine().split(" ");
		nn = new long[n];
		nnn = new long[n];
		deque = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			nn[i] = Integer.parseInt(x[i]);
			nnn[i] = Integer.parseInt(y[i]);
			deque.add(nn[0] * nnn[i]);
			deque.addLast(deque.removeFirst());
		}
		deque.addFirst(deque.removeLast());
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				deque.addLast(deque.removeFirst() + (nn[i] * nnn[j]));
			}
			deque.addFirst(deque.removeLast());
		}
		System.out.println(deque.getLast());
	}
}