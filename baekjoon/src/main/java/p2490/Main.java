package p2490;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 제목 : 구현
 * 단계 : 윷놀이
 * 힌트 :
 */
public class Main {

	static Map<Long, String> PLAYING = new HashMap();

	static {
		PLAYING.put(0L, "D");
		PLAYING.put(1L, "C");
		PLAYING.put(2L, "B");
		PLAYING.put(3L, "A");
		PLAYING.put(4L, "E");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			Integer[] n = new Integer[4];
			for (int j = 0; j < 4; j++) {
				n[j] = sc.nextInt();
			}
			System.out.println(PLAYING.get(Arrays.asList(n).stream().filter(e -> (e == 1)).count()));
		}
	}
}