package concurrent.locks;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class CLH_SpinLock {
	static class Node {
		private boolean isLocked = true; // 默认是需要锁
	}

	private volatile Node tail;

	private static final AtomicReferenceFieldUpdater<CLH_SpinLock, Node> UPDATER = AtomicReferenceFieldUpdater
			.newUpdater(CLH_SpinLock.class, Node.class, "tail");

	public void lock(Node currentThread) {
		Node preNode = UPDATER.getAndSet(this, currentThread);

		if (preNode != null) {
			// 已有线程占用了锁, 则进入自旋等待
			while (preNode.isLocked) {

			}
		}
	}

	public void unlock(Node currentThread) {
		if (!UPDATER.compareAndSet(this, currentThread, null)) {
			// 还有后续线程, 锁拥有者已经不是自己了

			// 改变状态, 让后续线程(锁拥有者)结束自旋
			currentThread.isLocked = false;

		}
	}
}
