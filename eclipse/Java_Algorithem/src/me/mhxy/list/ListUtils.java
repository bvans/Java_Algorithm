package me.mhxy.list;

import javax.sound.sampled.ReverbType;

public class ListUtils {
	public static ListUtils instance;

	public ListNode head;

	public static ListUtils getInstance(int[] arr) {
		if (instance == null) {
			synchronized (ListUtils.class) {
				if (instance == null) {
					instance = new ListUtils(arr);
				}
			}
		}
		return instance;
	}

	private ListUtils(int[] nodes) {
		if (nodes.length != 0) {
			head = new ListNode(nodes[0]);
		}
		ListNode node = head;
		for (int i = 1; i < nodes.length; i++) {
			node.next = new ListNode(nodes[i]);
			node = node.next;
		}
	}
	
	@Override
	public String toString() {
		String str = "[";
		ListNode node = head;
		while(node != null) {
			str += node.val + " ";
			node = node.next;
		}
		str += "]";
		return str;
	}
	
	public static void print(ListNode head) {
		String str = "[";
		ListNode node = head;
		while(node != null) {
			str += node.val + " ";
			node = node.next;
		}
		str += "]";
		System.out.println(str);
	};

	public boolean isPalindrome(ListNode head) {
		return false;
	}

	/**
	 * 迭代法逆转
	 */
	public static ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newHead = head.next;
		head.next = newHead.next;
		while (head.next != null) {
			ListNode next = head.next;
			head.next = next.next;
			next.next = newHead;
			newHead = next;
		}
		return newHead;
	}
	
	/**
	 * 把当前节点作为参数传入
	 * newHead应变为当前节点的前驱
	 */
	public static ListNode reverseList(ListNode head, ListNode newHead) {
		if(head == null) {
			return newHead;
		} 
		ListNode next = head.next;
		head.next = newHead;
		return reverseList(next, head);
	}
	
	
	
	public static void main(String[] args) {
		int[] data = new int[] {1, 2, 3, 4, 5, 6};
		
		ListUtils list = ListUtils.getInstance(data);
		ListNode test = new ListNode(0);
		
		reverseList(list.head);
		print(list.head);
	}
}
