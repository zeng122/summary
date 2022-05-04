package zzm.java.IO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;


public class NIOdemo2 {
    private ServerSocketChannel serverSocketChannel;

    public  void initServer(){
        try {
            //打开一个通道
            serverSocketChannel = ServerSocketChannel.open();

            //非阻塞
            serverSocketChannel.configureBlocking(false);

            //绑定端口号
            serverSocketChannel.socket().bind(new InetSocketAddress(9999));



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listen(){
        System.out.println("server started listening");
        ArrayList<SocketChannel> clients = new ArrayList<SocketChannel>();
        try {
            while (true) {
                SocketChannel socketChannel = serverSocketChannel.accept();
                if (socketChannel == null) {
                   // System.out.println("socketChannel is null");
                } else {
                    socketChannel.configureBlocking(false);
                    int port = socketChannel.socket().getPort();
                    System.out.println("client port:" + port);
                    clients.add(socketChannel);
                }

                ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
                for (SocketChannel c : clients) {
                    int num = c.read(byteBuffer);
                    if (num > 0) {
                        byteBuffer.flip();
                        byte[] aa = new byte[byteBuffer.limit()];
                        byteBuffer.get(aa);
                        System.out.println("get data:" + new String(aa));
                    } else {
                     //   System.out.println("not get data");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        NIOdemo2 niOdemo2 = new NIOdemo2();
        niOdemo2.initServer();
        niOdemo2.listen();

    }


}
