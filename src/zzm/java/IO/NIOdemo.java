package zzm.java.IO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * 基于select模型
 * 循环查找
 * 解决了资源阻塞问题，只有当可读的时候才会通知
 */
public class NIOdemo {
    private ServerSocketChannel serverSocketChannel;
    private Selector selector;

    public  void initServer(){
        try {
            //打开一个通道
            serverSocketChannel = ServerSocketChannel.open();

            //非阻塞
            serverSocketChannel.configureBlocking(false);

            //绑定端口号
            serverSocketChannel.socket().bind(new InetSocketAddress(9999));

            //注册
            selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listen(){
        System.out.println("server started listening");

        try {
            while (true){
                System.out.println("do");
                selector.select();

                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    if(key.isAcceptable()){
                        //有连接注册通道
                        SocketChannel channel = serverSocketChannel.accept();
                        channel.configureBlocking(false);
                        channel.register(selector, SelectionKey.OP_READ);
                    }
                    //有可读数据时
                    if(key.isReadable()){
                        //开辟子线程去处理
                        receiveAndReply(key);
                    }
                    if(key.isWritable()){

                    }
                    iterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void receiveAndReply(SelectionKey key){
        //获取通道
        SocketChannel channel = (SocketChannel)key.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(2560);
        try {
            int i = channel.read(byteBuffer);
            if(i != -1){
                String msg = new String(byteBuffer.array()).trim();
                System.out.println("NIO server received message = "+msg);
                String retMsg = "this is my first program of NIO,just do it!";
                channel.write(ByteBuffer.wrap(retMsg.getBytes()));
            }else{
                channel.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String [] args){
        NIOdemo niOdemo  = new NIOdemo();
        niOdemo.initServer();
        niOdemo.listen();
    }
}
