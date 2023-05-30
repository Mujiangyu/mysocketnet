package com.niit.tcpTest2;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Clien2 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 10000);

        OutputStream os = socket.getOutputStream();

        os.write("你好呀".getBytes());

        //关闭连接通道，相当于是IO流中的一个结束标记
        socket.shutdownOutput();

        InputStream is = socket.getInputStream();

        InputStreamReader isr = new InputStreamReader(is);
        int b;
        while ((b=isr.read())!=-1){
            System.out.print((char)b);

        }
        socket.close();
    }
}
