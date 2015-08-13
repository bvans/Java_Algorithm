package concurrent.locks;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.AbstractQueuedSynchronizer.ConditionObject;

public abstract class MySync extends AbstractQueuedSynchronizer{
	private static final long serialVersionUID = -5179523762034025860L;

	// 考虑到非公平锁和独占锁, 因此让子类去实现它
	abstract void lock();

	// 非公平的tryLock()
	// 公平的tryLock()在子类中实现, 因为公平的tryLock()也会去调用非公平的tryLock()
	final boolean nonfairTryAcquire(int acquires) {
		final Thread current = Thread.currentThread();
		int c = getState();
		if (c == 0) {
			if (compareAndSetState(0, acquires)) {
				//注意: 公平同步锁的条件为:
				//!hasQueuedPredecessors() && compareAndSetState(0, acquires)
				//公平锁: 既没有其他线程等待,也没有线程占有锁
				//非公平锁: 当前没有线程占用锁, 抢占式的, 我来了就是我的
				setExclusiveOwnerThread(current);
				return true;
			}
			// 否则, 有线程占用锁, 返回false, 尝试加锁失败

		} else if (current == getExclusiveOwnerThread()) {
			// 本线程为锁的拥有者

			// 增加本线程的加锁次数
			int nextc = c + acquires;
			if (nextc < 0) // overflow
				throw new Error("Maximum lock count exceeded");
			setState(nextc);
			return true;
		}
		return false;
	}

	protected final boolean tryRelease(int releases) {
		int c = getState() - releases;
		if (Thread.currentThread() != getExclusiveOwnerThread())
			// 本线程根本没有拿到锁
			throw new IllegalMonitorStateException();

		boolean free = false;
		if (c == 0) {
			// 本线程已经释放掉所有锁了
			free = true;
			setExclusiveOwnerThread(null);
		}
		setState(c);
		return free;
	}

	protected final boolean isHeldExclusively() {
		// While we must in general read state before owner,
		// we don't need to do so to check if current thread is owner
		return getExclusiveOwnerThread() == Thread.currentThread();
	}

	final ConditionObject newCondition() {
		return new ConditionObject();
	}

	// Methods relayed from outer class

	final Thread getOwner() {
		return getState() == 0 ? null : getExclusiveOwnerThread();
	}

	final int getHoldCount() {
		return isHeldExclusively() ? getState() : 0;
	}

	final boolean isLocked() {
		return getState() != 0;
	}

	/**
	 * Reconstitutes this lock instance from a stream.
	 * 
	 * @param s
	 *            the stream
	 */
	private void readObject(java.io.ObjectInputStream s)
			throws java.io.IOException, ClassNotFoundException {
		s.defaultReadObject();
		setState(0); // reset to unlocked state
	}
}


