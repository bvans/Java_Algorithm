package towardOffer;

public class ReverseList {
	public class Solution {
		public ListNode ReverseList(ListNode head) {
			if (head == null || head.next == null) {
				return head;
			}

			ListNode first = new ListNode(-1);
			while (head != null) {
				ListNode tmp = head.next;
				head.next = first.next;
				first.next = head;
				head = tmp;
			}
			return first.next;
		}
	}

}

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}
