package concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
	ReentrantLock locks;
	private MyLock lock = new MyLock();
	private int count = 0;
	
	public int inc() throws InterruptedException {
		lock.lock();
		int newCount = ++count;
		lock.unlock();
		return newCount;
	}
}

class MyLock {
	private boolean isLocked = false;
	
	public synchronized void lock() throws InterruptedException {
		while(isLocked) {
			wait();
		}
		isLocked = true;
	}
	
	public synchronized void unlock() {
		isLocked = false;
		notify();
	}
}

