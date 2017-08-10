import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/*
	url : http://codingdojang.com/scode/446?answer_mode=hide
	주어진 숫자를 인덱스라고 생각이 났음 (게임 끝!!!)
	예를 들어 1이리는 숫자가 있다면 첫번째 자라에 불을 켜둠(true) 2라는 숫자가 있으면 두번째 자리에 불을 켜둠(true) 이렇게 주어진 숫자를 정리함
	이후 주여진 숫자중 가장 큰 수만큼 반복해서 돌고 연속된 true 저장 false 이면 이전에 가장 긴 true 구간과 비교
*/
public class LargestSubset {

	static int i[] = {1, 6, 10, 4, 7, 9, 5};

	public static void main(String[] args) {
		int l = i.length;
		int m = 0;
		BitSet bs = new BitSet(Integer.MAX_VALUE);

		for (int j = 0; j < l; j++) {
			if (m < i[j]) m = i[j];
			bs.set(i[j], true);
		}

		List k = new ArrayList();
		List r = new ArrayList();

		for (int j = 0; j <= m; j++) {
			if (bs.get(j)) {
				k.add(j);
			} else {
				if (r.size() < k.size()) {
					r.clear();
					r.addAll(k);
					k.clear();
				}
			}
		}
		System.out.println(r);
		System.out.println(200L * 25000000L);
	}
}