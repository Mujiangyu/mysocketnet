package com.niit.udpdemo2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class GroupSendMessageDemo {
    public static void main(String[] args) throws IOException {
        /*
        * 组播发送端代码
        * */
        //创建MulticastSocket对象
        MulticastSocket ms = new MulticastSocket();

        //创建DatagrampPacket对象
        String str = "hello";
        byte[] bytes = str.getBytes();
        //组播时在指定IP地址时一定要使用组播地址
        InetAddress byName = InetAddress.getByName("224.0.0.1");
        int port = 10086;
        DatagramPacket dp = new DatagramPacket(bytes,bytes.length,byName,port);

        //调用MulticastSocket中的方法发送数据
        ms.send(dp);
        //释放资源
        ms.close();
    }
}
