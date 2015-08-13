package net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

public class NIOServer {
	public static void main(String[] args) throws IOException {
		int port = 8002;

		//创建选择器
		Selector selector = Selector.open();
		//打开监听通道
		ServerSocketChannel serverChannel = ServerSocketChannel.open();
		
		//监听通道的socket绑定本地端口
		serverChannel.socket().bind(new InetSocketAddress(port));
		//设置为非阻塞模式
		serverChannel.configureBlocking(false);

		// ServerChannel向selector注册
		serverChannel.register(selector, SelectionKey.OP_ACCEPT);

		while (true) {
			int n = selector.select();
			System.out.println("n:" + n);

			if (n == 0) {
				continue;
			}

			Iterator<SelectionKey> it = selector.selectedKeys().iterator();
			while (it.hasNext()) {
				SelectionKey key = it.next();

				if (key.isAcceptable()) {
					ServerSocketChannel channel = (ServerSocketChannel) key
							.channel();
					SocketChannel channle = channel.accept();
					if (channle == null) {
						System.out.println("空的 channel");
					}
				}

				if (key.isReadable()) {
					readDataFromChannel(key);
				}
			}
		}

	}

	public static void readDataFromChannel(SelectionKey key) throws IOException {
		// 获取与client的通道
		SocketChannel clientChannel = (SocketChannel) key.channel();
		// 得到并清空缓冲区
		ByteBuffer buffer = (ByteBuffer) key.attachment();

		buffer.clear();
		// 将通道中的数据读入buffer
		long size = clientChannel.read(buffer);
		if (size == -1) {
			System.out.println("客户端没有发送数据");
			clientChannel.close();
		}

		buffer.flip();
		String rcvStr = Charset.forName("utf8").decode(buffer).toString();
		System.out.println(rcvStr);

		key.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
	}
}
