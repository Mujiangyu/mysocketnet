package com.niit.udpdemo1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ReceiveMessageDemo {
    public static void main(String[] args) throws IOException {
        //接收数据


        //1.创建DatagramSocket对象
        //细节：
        //  再接收数据的时候，一定要绑定端口
        //  且绑定的端口一定要跟发送的端口保持一致

        //指定接收数据的端口号
        DatagramSocket ds = new DatagramSocket(10086);


        //接收数据包
        //接收的字节全部都放在这个字节数组中，并尽可能的装满这个数组
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
        //此方法是阻塞的
        //程序在执行到此处时，会一直等待
        //等待发送端发送消息
        ds.receive(dp);

        //解析数据包
        byte[] data = dp.getData();
        int len = dp.getLength();
        InetAddress address = dp.getAddress();
        int port = dp.getPort();
        System.out.println("数据：" + new String(data, 0, len));
        System.out.println("该数据是从" + address + "这台电脑中的" + port + "端口中发出的");
        ds.close();
    }
}
