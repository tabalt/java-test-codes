package language.usage.net;

import java.io.EOFException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NioServerDemo {

	private Selector selector;
	private ByteBuffer readBuffer = ByteBuffer.allocate(1024);//调整缓存的大小可以看到打印输出的变化
	private ByteBuffer sendBuffer = ByteBuffer.allocate(1024);//调整缓存的大小可以看到打印输出的变化

	String str;

	public void start() {

		try {
			// 打开服务器套接字通道
			ServerSocketChannel ssc = ServerSocketChannel.open();

			// 服务器配置为非阻塞
			ssc.configureBlocking(false);

			// 进行服务的绑定
			ssc.bind(new InetSocketAddress("localhost", 8001));

			// 通过open()方法找到Selector
			selector = Selector.open();

			// 注册到selector，等待连接
			ssc.register(selector, SelectionKey.OP_ACCEPT);
		} catch (Exception e) {
			System.out.println("listen failed, server will stop.");
			e.printStackTrace();
			return;
		}

		while (!Thread.currentThread().isInterrupted()) {

			try {
				selector.select();
			} catch (Exception e) {
				System.out.println("select failed, server will stop.");
				e.printStackTrace();
				return;
			}

			Set keys = selector.selectedKeys();
			Iterator keyIterator = keys.iterator();
			while (keyIterator.hasNext()) {
				SelectionKey key = (SelectionKey) keyIterator.next();
				try {
					if (!key.isValid()) {
						continue;
					}

					if (key.isAcceptable()) {
						accept(key);
					} else if (key.isReadable()) {
						read(key);
					} else if (key.isWritable()) {
						write(key);
					}

					keyIterator.remove(); //该事件已经处理，可以丢弃
				} catch (Exception e) {
					System.out.println("accept/read/write failed, server will continue to deal next connection.");
					e.printStackTrace();
					key.cancel();
				}
			}
		}
	}

	private void write(SelectionKey key) throws Exception {
		SocketChannel channel = (SocketChannel) key.channel();
		str += " from server";
		System.out.println("write:"+str);
		sendBuffer.clear();
		sendBuffer.put(str.getBytes());
		sendBuffer.flip();
		channel.write(sendBuffer);
		channel.register(selector, SelectionKey.OP_READ);
	}

	private void read(SelectionKey key) throws Exception {
		SocketChannel socketChannel = (SocketChannel) key.channel();
		// Clear out our read buffer so it's ready for new data
		this.readBuffer.clear();
		// readBuffer.flip();

		// Attempt to read off the channel
		int numRead;
		try {
			numRead = socketChannel.read(this.readBuffer);
		} catch (Exception e) {
			System.out.println("read message from client catch exception: ");
			e.printStackTrace();
			// The remote forcibly closed the connection, cancel
			// the selection key and close the channel.
			key.cancel();
			socketChannel.close();
			return;
		}

		System.out.println("numRead: " + numRead);
		if (numRead == -1) {
			throw new EOFException();
		}

		str = new String(readBuffer.array(), 0, numRead);
		System.out.println(str);

		if (str != null) {
			socketChannel.register(selector, SelectionKey.OP_WRITE);
		}
	}

	private void accept(SelectionKey key) throws Exception {
		ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
		SocketChannel clientChannel = ssc.accept();
		clientChannel.configureBlocking(false);
		clientChannel.register(selector, SelectionKey.OP_READ);
		System.out.println("\n========\na new client connected "+clientChannel.getRemoteAddress());
	}

	public static void main(String[] args) throws Exception {
		System.out.println("server started...");
		new NioServerDemo().start();
	}

}