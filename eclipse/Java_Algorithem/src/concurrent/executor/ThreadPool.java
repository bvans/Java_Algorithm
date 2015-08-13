package concurrent.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
	public static void main(String[] args) {
		ThreadPool pool = new ThreadPool();
		// pool.runCachedThreadPool();
		// new ThreadPool().runSingleThreadExecutror();

		//pool.runFixedThreadPool();
		pool.runScheduledThreadPool();
	}

	public void runScheduledThreadPool() {
		ScheduledThreadPoolExecutor pool = (ScheduledThreadPoolExecutor) Executors
				.newScheduledThreadPool(5);
		
		pool.schedule(new MyTask("任务1"), 3, TimeUnit.SECONDS);
		pool.schedule(new MyTask("任务2"), 3, TimeUnit.SECONDS);
		pool.schedule(new MyTask("任务3"), 3, TimeUnit.SECONDS);
	}

	public void runFixedThreadPool() {
		ExecutorService pool = Executors.newFixedThreadPool(3);

		for (int i = 0; i < 10; i++) {
			pool.execute(new MyTask("任务" + i));
		}

		pool.shutdown();
	}

	public void runCachedThreadPool() {
		ExecutorService pool = Executors.newCachedThreadPool();

		for (int i = 0; i < 100; i++) {
			pool.execute(new MyTask("任务" + i));
		}

		pool.shutdown();
	}

	public void runSingleThreadExecutror() {
		ExecutorService pool = Executors.newSingleThreadExecutor();

		pool.execute(new MyTask("任务1"));
		pool.execute(new MyTask("任务2"));
		pool.execute(new MyTask("任务3"));

		pool.shutdown();
	}
}

class MyTask implements Runnable {
	private final String taskName;

	public MyTask(String taskName) {
		this.taskName = taskName;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100000; i++)
			if (i % 279 == 0)
				System.out.println(taskName + "正在执行...");
	}

}
