package zzm.java.JavaWeb;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class JavaWeb1 {
    public static void main(String [] args){
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("服务端启动，等待其他人连接");
            while (true){
                Socket socket =  serverSocket.accept();
                System.out.println("有客户连接到本机："+socket.getLocalAddress());
                ChatWithUser chatWithUser = new ChatWithUser(serverSocket,socket);
                chatWithUser.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


class ChatWithUser extends  Thread{
    ServerSocket serverSocket;
    Socket socket;

    public ChatWithUser(ServerSocket serverSocket , Socket socket){
        this.serverSocket = serverSocket;
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            int n=0;
            while(n<10){
                System.out.println(br.readLine());
                n++;
            };
            OutputStream outputStream = socket.getOutputStream();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("HTTP/1.1 200 OK\r\n");
            stringBuffer.append("Content-type:text/html\r\n\r\n");
            stringBuffer.append("<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "\n" +
                    "<head>\n" +
                    "<meta charset=\"UTF-8\">\n" +
                    "<title>Hi</title>\n" +
                    "</head>\n" +
                    "\n" +
                    "<body>\n" +
                    "hello world\n" +
                    "</body>\n" +
                    "</html>\n");
            outputStream.write(stringBuffer.toString().getBytes());
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
