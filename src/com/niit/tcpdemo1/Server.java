package com.niit.tcpdemo1;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        /*
         * TCP协议接收数据
         * */
        //创建ServerSocket对象
        ServerSocket serverSocket = new ServerSocket(10000);

        //监听客户端的链接
        Socket socket = serverSocket.accept();

        //从通道中获取输入流读取数据
        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);

        int b;
        while ((b = isr.read()) != -1) {
            System.out.print((char) b);
        }
        socket.close();
        serverSocket.close();

    }
}
