package com.niit.tcpTest3;

import java.io.*;
import java.net.Socket;

public class Client3 {
    public static void main(String[] args) throws IOException {
        /*
         * 客户端上传本地文件，接收服务器的反馈
         * */

        //创建一个连接对象
        Socket socket = new Socket("127.0.0.1", 10000);

        BufferedOutputStream bos =
                new BufferedOutputStream(socket.getOutputStream());

        //创建一个本地文件输入流读取文件

       FileInputStream fis = new FileInputStream("E:\\Idea\\mysocketnet\\serverDir\\gudu.txt");

        int b;
        while ((b = fis.read()) != -1) {
            bos.write(b);
        }
        socket.shutdownOutput();

       BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
       String line = br.readLine();
        System.out.println(line);

        socket.close();
    }
}
