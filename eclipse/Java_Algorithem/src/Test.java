import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;

public class Test {

	public static void main(String[] args) throws IOException, InterruptedException {

		SocketChannel socketChannel = SocketChannel.open();
		socketChannel.configureBlocking(false);
		socketChannel.connect(new InetSocketAddress("t.cn", 80));
		
		while(true) {
			if(socketChannel.finishConnect()) {
				String get = "GET / HTTP/1.1\nHost: t.cn\nConnection: keep-alive";
				ByteBuffer buf = ByteBuffer.allocate(64);
				buf.wrap(get.getBytes());
				int bytesConut = socketChannel.write(buf);
				break;
			} else {
				Thread.currentThread().sleep(1000);
			}
		}
		
	}

	public static void startServer() throws IOException {
		ServerSocket serverSocket = new ServerSocket(8888);
		Socket socket = serverSocket.accept();// 阻塞等待消息
		socket.setTcpNoDelay(true);
		socket.setKeepAlive(true);
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();
		os.write("Hello".getBytes("utf8"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(is,
				"utf8"));
		String buff = reader.readLine();
		while (buff != null) {
			System.out.println(buff);
			buff = reader.readLine();
		}
		reader.close();
		is.close();
		os.close();
		serverSocket.close();
	}
}
