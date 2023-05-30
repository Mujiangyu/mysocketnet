package com.niit.tcpdemo1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        /*
         * TCP协议发送数据
         * 客户端
         * */
        //创建Socket对象
        //在创建对象时会链接服务端，如果链接不上，代码会报错
        Socket socket = new Socket("127.0.0.1", 10000);

        //可以从连接通道中获取输出流
        OutputStream os = socket.getOutputStream();
        //写出数据
        os.write("你好".getBytes());

        socket.close();

    }
}
