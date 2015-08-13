package concurrent.locks;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

import concurrent.locks.MCS_SpinLock.Node;

public class MCS_SpinLock {
	public static class Node {
		volatile Node next;
		// 默认是在等待锁
		volatile boolean isBlock = true;
	}

	// 指向最后一个申请锁的node
	volatile Node queue;

	// 将某个类的某个字段定义为原子类型
	private static final 
	AtomicReferenceFieldUpdater<MCS_SpinLock, Node> UPDATER 
	= AtomicReferenceFieldUpdater
			.newUpdater(MCS_SpinLock.class, Node.class, "queue");

	public void lock(Node currentThread) {
		Node pre = UPDATER.getAndSet(this, currentThread);
		if(pre != null) {
			pre.next = currentThread;
			
			while(currentThread.isBlock){
			}
		}
	}
	
	public void unlock(Node currentThread) {
		if(currentThread.isBlock) {
			//只有锁拥有者才能释放锁
			return;
		}
		
		if(currentThread.next == null) {
			if(UPDATER.compareAndSet(this, currentThread, null)) {
				//确实后边没有人了
				return;
			}
			
			while(currentThread == null) {
			}
		}
		
		currentThread.next.isBlock = false;
		currentThread.next = null; //gc释放掉
	}

}
