package concurrent;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Producer_Consumer {
	public static void main(String[] args) {
		ExecutorService e = Executors.newCachedThreadPool();
		ThreadPoolExecutor b;
		Pool p = new Pool();
		new Consumer(p).start();
		new Producer(p).start();
	}
	
	static class Consumer extends Thread {
		private Pool p ;
		public Consumer(Pool pool) {
			p = pool;
		}
		
		@Override
		public void run() {
			for(int i = 0; i < 100; i++) {
				p.del();
			}
		}
	} 
	
	static class Producer extends Thread {
		private Pool p ;
		public Producer(Pool pool) {
			p = pool;
		}
		
		@Override
		public void run() {
			for(int i = 0; i < 100; i++) {
				p.add();
			}
		}
	}
	
	
}

class Pool {
	private static final int MAX_SIZE = 10;
	
	private static LinkedList<Calendar> pool = new LinkedList<Calendar>();
	
	public synchronized void add() {
		while(pool.size() >= MAX_SIZE) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		Calendar c = Calendar.getInstance();
		pool.add(c);
		System.out.println("添加" + c.getTimeInMillis());
		notifyAll();
	}
	
	public synchronized void del() {
		while(pool.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Calendar c= pool.removeFirst();
		System.out.println("删除" + c.getTimeInMillis());
		notifyAll();
	}
}

