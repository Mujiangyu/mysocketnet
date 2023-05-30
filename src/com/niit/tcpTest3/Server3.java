package com.niit.tcpTest3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server3 {
    public static void main(String[] args) throws IOException {
        /*
         * 服务端接收客户端发送的文件，上传完毕后想客户端发出反馈
         * */


        ServerSocket serverSocket = new ServerSocket(10000);
        Socket socket = serverSocket.accept();
        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream("a.txt");
        int b;
        while ((b=is.read()) != -1){
            fos.write(b);
        }


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("上传成功");
        bw.newLine();
        bw.flush();
        socket.close();
        serverSocket.close();
    }
}
