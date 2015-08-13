package concurrent;

import java.util.Random;

public class ThreadDemo implements Runnable {
	Student student = new Student();
	int count = 0;

	public static void main(String[] args) {
		ThreadDemo td = new ThreadDemo();
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

		synchronized (this) {
			System.out.println(curThread + " 第一次获得锁");
			try {
				count++;
				Thread.sleep(5000);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				System.out.println(curThread + " first read count: " + count);
			}
		}

		System.out.println(curThread + " 第一次释放锁");

		synchronized (student) {
			System.out.println(curThread + " 第二次获得锁");
			Random random = new Random();
			int age = random.nextInt(100);
			System.out.println(curThread + "设置age:" + age);
			this.student.setAge(age);
			System.out.println(curThread + "第一次读到的age为: "
					+ this.student.getAge());

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				System.out.println(curThread + "第二次读到的age为: "
						+ this.student.getAge());
			}
		}
		
		System.out.println(curThread + "释放第二次锁");
	}

	@Override
	public void run() {
		accessStudent();
	}

}

class Student {

	private int age = 0;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}