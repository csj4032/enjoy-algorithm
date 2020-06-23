package com.genius.apss.chap08;

public class BinomialCoefficient {

	private static int[][] cache = new int[100][100];

	public int bino(int n, int r) {
		if (r == 0 || n == r) return 1;
		return bino(n - 1, r - 1) + bino(n - 1, r);
	}

	public int bino2(int n, int r) {
		if (r == 0 || n == r) return 1;
		if (cache[n][r] != -1) return cache[n][r];
		return cache[n][r] = bino2(n - 1, r - 1) + bino2(n - 1, r);
	}

	public static void main(String[] args) {
		BinomialCoefficient binomialCoefficient = new BinomialCoefficient();
		long start = System.currentTimeMillis();
		System.out.println("1 : " + binomialCoefficient.bino2(35, 30));
		System.out.println(System.currentTimeMillis() - start);

		start = System.currentTimeMillis();
		System.out.println("2 : " + binomialCoefficient.bino2(35, 30));
		System.out.println(System.currentTimeMillis() - start);
	}
}