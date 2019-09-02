package p2511;

/**
 * 제목 : 카드놀이
 * 링크 : https://www.acmicpc.net/problem/2511
 */
import java.util.Scanner;

public class Main {

	static int[] A = new int[10];
	static int[] B = new int[10];
	static int P = 0;
	static int Q = 0;
	static String W = "D";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 10; i++) A[i] = sc.nextInt();
		for (int i = 0; i < 10; i++) B[i] = sc.nextInt();

		for (int i = 0; i < 10; i++) {
			if (A[i] > B[i]) {
				P += 3;
				W = "A";
			} else if (A[i] < B[i]) {
				Q += 3;
				W = "B";
			} else if (A[i] == B[i]) {
				P += 1;
				Q += 1;
			}
		}

		System.out.println(P + " " + Q);

		if (P > Q) {
			System.out.println("A");
		} else if (P < Q) {
			System.out.println("B");
		} else {
			if (W.equals("A")) {
				System.out.println("A");
			} else if (W.equals("B")) {
				System.out.println("B");
			} else {
				System.out.println("D");
			}
		}
	}
}
