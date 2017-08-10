import java.util.Scanner;

public class ReverseAndAdd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			reverse(sc.nextLong(), 1);
		}
	}

	private static void reverse(Long t, Integer r) {
		StringBuffer sb = new StringBuffer(t.toString());

		Long k = t + Long.valueOf(sb.reverse().toString());

		StringBuffer sbb = new StringBuffer(String.valueOf(k));

		if (String.valueOf(k).equals(sbb.reverse().toString()) || r > 1000 || t > 4294967294L) {
			System.out.println(r + " " + sbb.toString());
		} else {
			r = r + 1;
			reverse(k, r);
		}
	}
}

//0222000022211
//4294967295
//679587785976
//756666666657
//3 195 265 750