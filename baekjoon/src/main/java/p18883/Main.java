package p18883;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
//		var sc = new Scanner(System.in);
//		var n = sc.nextInt();
//		var m = sc.nextInt();
//		var sb = new StringBuilder();
//		for (int i = 1; i <= n * m; i++) {
//			sb.append(i);
//			if (i % m == 0) {
//				sb.append("\n");
//			} else {
//				sb.append(" ");
//			}
//		}
//		System.out.println(sb.toString());

		int[] data = {4, 7, 5, 9, 6};
		int[] data2 = {6 ,9 ,5 ,7 ,4};
		System.out.println(lowerBound(data, 1,4));
		System.out.println(lowerBound(data, 2,7));
		System.out.println(lowerBound(data, 3,5));
		System.out.println(lowerBound(data, 4,9));
		System.out.println(lowerBound(data, 5,6));
	}

	public static int lowerBound(int data[], int low, int value) {
		int high = data.length;
		int mid = 0;
		while (low < high) {
			mid = (low + high) / 2;
			if (value <= data[mid]) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}

	public static int upperBound(int data[], int value) {
		int low = 0;
		int high = data.length;
		int mid = 0;
		while (low < high) {
			mid = (low + high) / 2;
			if (value >= data[mid]) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}
}