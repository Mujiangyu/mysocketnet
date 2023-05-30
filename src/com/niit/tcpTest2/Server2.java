package com.niit.tcpTest2;

import com.sun.tools.javac.Main;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10000);
        Socket socket = serverSocket.accept();
        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);

        int len;
        while ((len=isr.read())!=-1){
            System.out.print((char)len);
        }

        OutputStream os = socket.getOutputStream();
        os.write("成功接收数据".getBytes());
        socket.close();
        serverSocket.close();
    }
}
