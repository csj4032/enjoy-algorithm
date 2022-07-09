package medium;

import java.util.HashMap;
import java.util.Map;

public class SortList {

	public ListNode sortList(ListNode head) {
		ListNode _prev = head;
		ListNode _next = head.next;
		ListNode _temp;
		Map<Integer, Integer> map = new HashMap();
		map.entrySet();
		for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
			entry.getValue();
			entry.getKey();
		}
		while (true) {
			if (_prev.val > _next.val) {
				_temp = _next.next;
				_prev.next = _temp;
				_next.next = _prev;
				_prev = _next;
				int[] array1 = new int[Integer.MAX_VALUE];
			} else {
				_prev = _prev.next;
				_next = _next.next;
			}
			if (_prev.next == null) break;
		}
		return _prev;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}