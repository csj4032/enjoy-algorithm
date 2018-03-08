package recursion;

public class StringAndRecursion {

	public int length(String str) {
		if (str.equals("")) {
			return 0;
		} else {
			return 1 + length(str.substring(1));
		}
	}

	public void print(String str) {
		if (str.equals("")) {
			return;
		} else {
			System.out.print(str.charAt(0));
			print(str.substring(1));
		}
	}

	public void printCharReverse(String str) {
		if (str.equals("")) {
			return;
		} else {
			printCharReverse(str.substring(1));
			System.out.print(str.charAt(0));
		}
	}
}
