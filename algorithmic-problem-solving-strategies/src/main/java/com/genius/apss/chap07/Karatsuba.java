package com.genius.apss.chap07;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.reverse;

public class Karatsuba {

	public static void main(String[] args) {
		System.out.println(multiply(List.of(3, 2, 1), List.of(6, 5, 4)));
		System.out.println(multiply(List.of(4, 3, 2, 1), List.of(8, 7, 6, 5)));
		System.out.println(multiply(List.of(5, 4, 3, 2, 1), List.of(9, 8, 7, 6)));
	}

	public static List<Integer> multiply(List<Integer> a, List<Integer> b) {
		Integer[] t = new Integer[a.size() + b.size()];
		Arrays.fill(t, 0);
		List<Integer> c = Arrays.stream(t).collect(Collectors.toList());
		for (int i = 0; i < a.size(); ++i) {
			for (int j = 0; j < b.size(); ++j) {
				Integer k = i + j;
				Integer l = c.get(k);
				c.set(k, l + (a.get(i) * b.get(j)));
			}
		}
		normalize(c);
		reverse(c);
		return c.subList(1, c.size());
	}

	public static void normalize(List<Integer> nums) {
		for (int i = 0; i < nums.size() - 1; i++) {
			Integer j = nums.get(i);
			Integer k = nums.get(i + 1);
			nums.set(i + 1, k + j / 10);
			nums.set(i, j % 10);
		}
	}
}
