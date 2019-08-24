package p2941;

import java.util.*;

/**
 * 제목 : 크로아티아 알파벳
 * 링크 : https://www.acmicpc.net/problem/2941
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(str.replaceAll("c=|c-|dz=|d-|lj|nj|s=|z="," ").length());
	}
}