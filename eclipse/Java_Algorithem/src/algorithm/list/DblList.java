package algorithm.list;

import java.util.Stack;

public class DblList {
	private DblNode head, tail;
	
	public DblList() {
		Stack s;
		head = null;
		tail = null;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void addToTail(Object el) {
		if (isEmpty()) {
			head = tail = new DblNode(el);
		} else {
			tail.next = new DblNode(el, null, tail);
			tail.prev.next = tail;
		}
	}
	
	public Object removeFromTail() {
		Object el = tail.info;
		if(head == tail) {
			//只有一个节点
			head = tail = null;
		} else {
			tail = tail.prev;
			tail.next = null;
		}
		return el;
	}
}

class DblNode {
	public Object info;
	public DblNode next, prev;
	
	public DblNode(Object el) {
		this(el, null, null);
	}
	
	public DblNode(Object el, DblNode next, DblNode prev) {
		this.info = el;
		this.next = next;
		this.prev = prev;
	}
}
