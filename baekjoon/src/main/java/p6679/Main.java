package p6679;

public class Main {

	public static void main(String[] args) {
		for (int i = 2992; i < 10000; i++) {
			String a = String.valueOf(i);
			String b = Integer.toOctalString(i);
			String c = Integer.toHexString(i);

			System.out.println(a + " " + b + " " + c);
		}
	}
}
