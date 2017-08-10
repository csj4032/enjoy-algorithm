/**
 * URL : http://codingdojang.com/scode/514
 * 각자리수를 찾는 방법을 재귀로 구현
 */
public class PingPong {

	public static void main(String[] args) {
		pingpong(68);
	}

	private static void pingpong(int n) {
		ping(1, 1, n, 1);
	}

	private static void ping(int i, int v, int n, int d) {
		if (i == n) {
			System.out.println(i + " " + v);
			return;
		}
		i = i + 1;
		v = v + d;
		boolean b = pong(i, 10);
		if (i % 7 == 0 || b) {
			d = d * -1;
		}
		ping(i, v, n, d);
	}

	private static boolean pong(int i, int d) {
		if ((i / d) < 10) return false;
		if (i % d == 7) return true;
		return pong(i, 10 * d);
	}
}