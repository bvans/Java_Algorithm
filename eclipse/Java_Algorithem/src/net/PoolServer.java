package net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PoolServer implements Runnable {
	private static final int PORT = 8002;
	private static final int POOL_SIZE = 4;
	private final ServerSocket serverSocket;
	private final ExecutorService pool;

	public PoolServer() throws IOException {
		serverSocket = new ServerSocket(PORT);
		pool = Executors.newFixedThreadPool(POOL_SIZE);
	}

	@Override
	public void run() {
		try {
			for (;;) {
				pool.execute(new Handler(serverSocket.accept()));
			}
		} catch (IOException e) {
			pool.shutdown();
		}

	}
	
	void shutdownAndAwaitTermination(ExecutorService pool) {
		pool.shutdown();  //disable new tasks from being submitted
		try {
			if(!pool.awaitTermination(60, TimeUnit.SECONDS)) {
				//等待60s后尝试暂停所有任务
				pool.shutdownNow();
				if(!pool.awaitTermination(60, TimeUnit.SECONDS)) {
					//存在无法暂停的任务
					 System.err.println("Pool did not terminate");
				}
			}
		} catch (InterruptedException e) {
			//当前任务也被中断了
			pool.shutdownNow();
			 Thread.currentThread().interrupt();
		}
	}
	
	class Handler implements Runnable {
		private final Socket socket;

		public Handler(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			// readData()
		}
	}
}


