package levelTwo;

public class CountingAfterQuadCompression {

	public int[] solution(int[][] arr) {
		int length = arr.length;
		int zero = 0;
		int one = 0;
		String result = recursive(length / 2, length / 2, length / 2, arr, "");
		for (int i = 0; i < result.length(); i++) {
			if (result.charAt(i) == '0') {
				zero++;
			} else {
				one++;
			}
		}
		return new int[]{zero, one};
	}

	private String recursive(int cx, int cy, int length, int[][] arr, String dir) {
		if (length == 1) {
			int tl = arr[cy - 1][cx - 1];
			int tr = arr[cy - 1][cx];
			int br = arr[cy][cx - 1];
			int bl = arr[cy][cx];
			if (tl + tr + br + bl == 0) {
				return "0";
			} else if (tl + tr + br + bl == 4) {
				return "1";
			}
			return tl + "" + tr + "" + br + "" + bl;
		}
		int temp = length / 2;
		String tl = recursive(cx - temp, cy - temp, temp, arr, "TL");
		String tr = recursive(cx + temp, cy - temp, temp, arr, "TR");
		String br = recursive(cx - temp, cy + temp, temp, arr, "BR");
		String bl = recursive(cx + temp, cy + temp, temp, arr, "BL");
		if (tl.equals("1") && tr.equals("1") && br.equals("1") && bl.equals("1")) {
			return "1";
		} else if (tl.equals("0") && tr.equals("0") && br.equals("0") && bl.equals("0")) {
			return "0";
		}
		return tl + "" + tr + "" + br + "" + bl;
	}
}

