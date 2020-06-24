package com.genius.apss.chap14;

import java.util.ArrayList;
import java.util.List;

public class Potion {

	private int gcd(int p, int q) {
		if (q == 0) return p;
		return gcd(q, (p % q));
	}

	private int ceil(int a, int b) {
		System.out.println(a + " " + b + " " + (a + b - 1) + " " + b + " " + (a + b - 1) / b);
		return (a + b - 1) / b;
	}

	List<Integer> solve(List<Integer> recipe, List<Integer> put) {
		int n = recipe.size();
		int b = recipe.get(0);
		for (int i = 1; i < n; i++) {
			b = gcd(b, recipe.get(i));
		}
		int a = b;
		for (int i = 0; i < n; i++) {
			a = Math.max(a, ceil(put.get(i) * b, recipe.get(i)));
		}
		List<Integer> ret = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			Integer k = recipe.get(i) * a / b - put.get(i);
			ret.add(k);
		}
		return ret;
	}

	public static void main(String[] args) {
		Potion potion = new Potion();
		System.out.println(potion.solve(List.of(4, 6, 2, 4), List.of(6, 4, 2, 4)));
	}
}

// 2
//양 4 6 2 4
//넣 6 4 2 4
//추 0 5 1 2
//마 6 9 3 6
