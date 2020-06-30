package p2170;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		var n = Integer.parseInt(br.readLine());
		var l = new ArrayList<Tuple>();
		for (int i = 0; i < n; i++) {
			var ss = br.readLine().split(" ");
			l.add(new Tuple(Integer.parseInt(ss[0]), Integer.parseInt(ss[1])));
		}
		Collections.sort(l);
		var merge = l.get(0);
		var k = merge.end - merge.start;
		for (int i = 1; i < n; i++) {
			var target = l.get(i);
			if (merge.end < target.start) {
				k += target.end - target.start;
				merge = target;
			} else {
				var t = target.end - merge.end;
				if (t > 0) {
					merge.end = target.end;
					k += t;
				}
			}
		}
		System.out.println(k);
	}
}

class Tuple implements Comparable<Tuple> {
	Integer start;
	Integer end;

	public Tuple(Integer start, Integer end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public String toString() {
		return "Tuple{" + "start=" + start + ", end=" + end + '}';
	}

	@Override
	public int compareTo(Tuple o) {
		int c = this.start.compareTo(o.start);
		return c == 0 ? this.end.compareTo(o.end) : this.start.compareTo(o.start);
	}
}

//4
//1 3
//2 9
//3 5
//10 11