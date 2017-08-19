package p1011;

import java.util.*;

// http://blog.naver.com/PostView.nhn?blogId=occidere&logNo=220982644540&parentCategoryNo=&categoryNo=&viewDate=&isShowPopularPosts=false&from=postView
// http://jaykaychoi.tistory.com/89
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			long a = sc.nextLong();
			long b = sc.nextLong();
			System.out.println(solution(b - a));
		}
	}

	private static long solution(long dist) {
		long n, powN, minN, maxN, result;
		for (n = 1; ; n++) {
			powN = n * n;
			minN = powN - n + 1;
			maxN = powN + 1 + n - 1;
			if (minN <= dist && maxN >= dist) {
				if (minN <= dist && dist <= powN) {
					result = (n << 1) - 1;
				} else {
					result = (n << 1);
				}
				break;
			}
		}
		return result;
	}
}