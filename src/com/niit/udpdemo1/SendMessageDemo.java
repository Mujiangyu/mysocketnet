package com.niit.udpdemo1;

import java.io.IOException;
import java.net.*;

public class SendMessageDemo {
    public static void main(String[] args) throws IOException {
        //发送数据
        //UDP协议是面向无连接的协议，特点是速度快，一次传输的数据有大小限制
        //再传输数据时，不会判断似乎都有连接，直接发送，可能会有数据的丢失

        //创建对象
        //细节：
        //创建对象是会绑定一个端口，以后就可以通过这个端口号往外发送数据
        //空参：再所有可用的端口号中，随机一个进行使用
        //有参：指定端口号进行绑定
        DatagramSocket ds = new DatagramSocket();

        //打包数据
        String str = "交个朋友吧！";
        byte[] bytes = str.getBytes();
        InetAddress byAddress = InetAddress.getByName("127.0.0.1");
        //发送到哪个端口
        int port = 10086;
        DatagramPacket dp = new DatagramPacket(bytes,bytes.length,byAddress,port);

        ds.send(dp);
        ds.close();
    }
}
