package concurrent;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo2 implements Runnable {
	Student student = new Student();
	int count = 0;
	ReentrantLock lock1 = new ReentrantLock();
	ReentrantLock lock2 = new ReentrantLock();

	public static void main(String[] args) {
		ThreadDemo2 td = new ThreadDemo2();
		Thread t1 = new Thread(td, "a");
		Thread t2 = new Thread(td, "b");
		Thread t3 = new Thread(td, "c");
		t1.start();
		t2.start();
		t3.start();
	}

	public void accessStudent() {
		String curThread = Thread.currentThread().getName();
		System.out.println(curThread + " is running!");

		try {
			lock1.lock();
			System.out.println(curThread + " 获得锁1");
			count++;
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println(curThread + " first read count: " + count);
			lock1.unlock();
			System.out.println(curThread + " 释放锁1");
		}

		try {
			lock2.lock();
			System.out.println(curThread + " 获得锁2");
			Random random = new Random();
			int age = random.nextInt(100);
			System.out.println(curThread + "设置age:" + age);
			this.student.setAge(age);
			System.out.println(curThread + "第一次读到的age为: "
					+ this.student.getAge());
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println(curThread + "第二次读到的age为: "
					+ this.student.getAge());
			lock2.unlock();
			System.out.println(curThread + "释放锁2");
		}

	}

	@Override
	public void run() {
		accessStudent();
	}

}
