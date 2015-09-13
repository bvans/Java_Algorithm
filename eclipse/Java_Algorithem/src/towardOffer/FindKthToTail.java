package towardOffer;

public class FindKthToTail {
	public ListNode findKthToTail(ListNode head, int k) {
		if (head == null || k <= 0) {
			return null;
		}

		ListNode first, second;
		first = second = head;

		for (int i = 0; i < k - 1 && first != null; i++) {
			first = first.next;
		}
		
		if (first == null) {
			return null;
		}
		
		while(first.next != null) {
			first = first.next;
			second = second.next;
		}
		return second;
	}
}
