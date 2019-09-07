package p7572;

import java.util.Scanner;

public class Main {

	// 갑 을 병 정 무 기 경 신 임 계
	// 자 축 인 묘 진 사 오 미 신 유 술 해
	static int[] a = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	static String[] b = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L"};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int aa = (n + 6) % 10;
		int bb = (n + 8) % 12;
		System.out.println(b[bb] + a[aa]);
	}
}
