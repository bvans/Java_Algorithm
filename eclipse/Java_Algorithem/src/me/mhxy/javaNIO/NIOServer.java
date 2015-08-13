package me.mhxy.javaNIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NIOServer {
	private Selector selector;

	public void initServer(int port) throws IOException {
		// 获得一个ServerChannel通道
		ServerSocketChannel serverChannel = ServerSocketChannel.open();
		// 设为非阻塞
		serverChannel.configureBlocking(false);
		// 绑定端口号
		serverChannel.socket().bind(new InetSocketAddress(port));

		this.selector = Selector.open();
		// 像selector注册该serverChannel, 并监听accept事件
		serverChannel.register(selector, SelectionKey.OP_ACCEPT);
	}

	/**
	 * 轮询的处理事件
	 * 
	 * @throws IOException
	 */
	public void listen() throws IOException {
		System.out.println("server started!");
		selector.select();
		Iterator ite = this.selector.selectedKeys().iterator();
		while (ite.hasNext()) {
			SelectionKey key = (SelectionKey) ite.next();
			// 删除已选的key,以防重复处理
			ite.remove();
			// 客户端请求连接事件
			if (key.isAcceptable()) {
				ServerSocketChannel server = (ServerSocketChannel) key
						.channel();
				// 获得和客户端连接的通道
				SocketChannel channel = server.accept();
				// 设置成非阻塞
				channel.configureBlocking(false);

				// 在这里可以给客户端发送信息哦
				channel.write(ByteBuffer.wrap(new String("向客户端发送了一条信息")
						.getBytes()));
				// 在和客户端连接成功之后，为了可以接收到客户端的信息，需要给通道设置读的权限。
				channel.register(this.selector, SelectionKey.OP_READ);

				// 获得了可读的事件
			} else if (key.isReadable()) {
				read(key);
			}

		}
	}

	public void read(SelectionKey key) throws IOException {
		SocketChannel channel = (SocketChannel) key.channel();
		ByteBuffer buff = ByteBuffer.allocate(10);
		channel.read(buff);

		String msg = "";
		msg = new String(buff.array(), "utf8");
		System.out.println("服务器收到消息:" + msg);

		// 回复消息
//		buff.compact();
//		buff.wrap(msg.getBytes("utf8"));
//		channel.write(buff);
		ByteBuffer outBuffer = ByteBuffer.wrap(msg.getBytes());  
        channel.write(outBuffer);// 将消息回送给客户端  
	}

	public static void main(String[] args) {
		NIOServer server = new NIOServer();
		try {
			server.initServer(8888);
			server.listen();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
