package concurrent.locks;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁 http://coderbee.net/index.php/concurrent/20131115/577/comment-page-1
 *
 */
public class SpinLock {
	// 锁的拥有者(线程)
	private AtomicReference<Thread> owner = new AtomicReference<Thread>();

	public void lock() {
		Thread currentThread = Thread.currentThread();

		// 如果锁未被占用, 则设置前线程是锁的拥有者;
		//否则, 自旋等待知道锁被其他线程释放
		while (owner.compareAndSet(null, currentThread)) {
		}
	}
	
	public void unlock() {
		Thread currentThread = Thread.currentThread();
		
		//只有锁的拥有者才能释放锁
		owner.compareAndSet(currentThread, null);
	}
}
