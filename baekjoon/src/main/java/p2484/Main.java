package p2484;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 제목 : 주사위 네개
 * 링크 : https://www.acmicpc.net/problem/2484
 *
 * 모든 경우 조건
 * if(a==b&&b==c&&c==d)m=50000+a*5000;
 * 	else if((a==b)+(a==c)+(a==d)==2)m=10000+a*1000;
 * 	else if(b==c&&c==d)m=10000+b*1000;
 * 	else if((a==b)+(a==c)+(a==d)+(b==c)+(b==d)+(c==d)==2)m=2000+(a+b+c+d)/2*500;
 * 	else if(a==b||a==c||a==d)m=1000+a*100;
 * 	else if(b==c||b==d)m=1000+b*100;
 * 	else if(c==d)m=1000+c*100;
 * 	else if(a>b&&a>c&&a>d)m=a*100;
 * 	else if(b>c&&b>d)m=b*100;
 * 	else if(c>d)m=c*100;
 * 	else m=d*100;
 *
 *  연속 3 3 3 3 나올 경우
 * 	주사위 배열 [0,0,4,0,0,0]
 */
public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = 0;
		for (int i = 0; i < n; i++) {
			List<Integer> m = new ArrayList<>();
			for (int j = 0; j < 4; j++) {
				m.add(sc.nextInt());
			}
			k = Math.max(k, sum(m));
		}
		System.out.println(k);
	}

	private static int sum(List<Integer> m) {
		var k = m.stream().collect(Collectors.groupingBy(Integer::intValue));
		var t = 0;
		if (k.keySet().size() == 1) {
			t = k.keySet().stream().findFirst().get() * 5000 + 50000;
		} else if (k.keySet().size() == 2) {
			boolean b = k.values().stream().allMatch(v -> v.size() == 2);
			if (!b) {
				t = k.values().stream().filter(v -> v.size() == 3).map(v -> v.get(0) * 1000).findFirst().get() + 10000;
			} else {
				t = k.values().stream().filter(v -> v.size() == 2).mapToInt(v -> v.get(0) * 500).sum() + 2000;
			}
		} else if (k.keySet().size() == 3) {
			t = k.values().stream().filter(v -> v.size() == 2).mapToInt(v -> v.get(0) * 100).sum() + 1000;
		} else if (k.keySet().size() == 4) {
			var q = k.keySet().stream().sorted(Collections.reverseOrder()).findFirst().get();
			t = q * 100;
		}
		return t;
	}
}