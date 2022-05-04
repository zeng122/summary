package zzm.java.IO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NIOClient {


    SocketChannel channel;

    public void initClient(){
        InetSocketAddress address = new InetSocketAddress("127.0.0.1",9999);
        try {
            this.channel = SocketChannel.open(address);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * just do the thing which this function can do
     */
    public void sendAndRecv(){
        byte[] msg = "I want to be more powerful".getBytes();
        ByteBuffer byteBuffer = ByteBuffer.wrap(msg);
        try {
            channel.write(byteBuffer);
            byteBuffer.clear();
            channel.read(byteBuffer);
            System.out.println("Client received :"+new String(byteBuffer.array()).trim());
            channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String [] args){
        NIOClient client = new NIOClient();
        client.initClient();
        client.sendAndRecv();
    }
}
