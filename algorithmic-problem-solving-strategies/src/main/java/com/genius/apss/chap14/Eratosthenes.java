package com.genius.apss.chap14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Eratosthenes {

	private int minFactor[] = new int[100];

	private void eratosthenes(int n) {
		minFactor[0] = -1;
		minFactor[1] = -1;

		for (int i = 2; i < n; i++) minFactor[i] = i;

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (minFactor[i] == i) {
				for (int j = i * i; j <= n; j += i) {
					if (minFactor[j] == j) minFactor[j] = i;
				}
			}
		}
		System.out.println(Arrays.toString(minFactor));
	}

	private List<Integer> factor(int n) {
		List<Integer> factor = new ArrayList<>();
		while (n > 1) {
			factor.add(minFactor[n]);
			n /= minFactor[n];
		}
		System.out.println(factor);
		return factor;
	}

	public static void main(String[] args) {
		Eratosthenes eratosthenes = new Eratosthenes();
		eratosthenes.eratosthenes(50);
		eratosthenes.factor(12);
	}
}
