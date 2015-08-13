package net;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws UnknownHostException,
			IOException {
		Socket client = new Socket("localhost", 8002);
		BufferedOutputStream bos = new BufferedOutputStream(
				client.getOutputStream());
		bos.write("hello, world".getBytes("utf8"));
		bos.close();
		client.close();
	}
}
