package com.niit.udptest;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ReceiveTestDemo1 {
    public static void main(String[] args) throws IOException {
        /*
        * UDP接收数据，因为接收端不知道发送端什么时候停止发送，所以采取死循环
        * */

//        创建datagrampsocket对象，并指定接收数据的端口号
        DatagramSocket ds = new DatagramSocket(10010);

        //接收数据包
        byte[] bytes = new byte[1024];

        DatagramPacket dp = new DatagramPacket(bytes,bytes.length);

        while (true) {
            ds.receive(dp);
            byte[] data = dp.getData();
            int length = dp.getLength();
            String hostName = dp.getAddress().getHostName();
            System.out.println("数据源是 "+hostName+" 数据为: "+new String(data,0,length));
        }
    }
}
