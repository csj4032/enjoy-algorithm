package levelTwo;

public class Carpet {

	public int[] solution(int brown, int yellow) {
		int h = 0, w = 0;
		int rh = 0, rw = 0;
		while (true) {
			h = h + 1;
			w = yellow / h;
			if (yellow % h == 0) {
				rw = w + 2;
				rh = h + 2;
			} else {
				rw = w + 3;
				rh = h + 2;
			}
			if ((rw * rh) == (brown + yellow)) break;
		}
		return new int[]{rw, rh};
	}
}
