package com.niit.udpdemo2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class GroupReceiveMessageDemo2 {
    public static void main(String[] args) throws IOException {
        /*
         * 组播接收端代码
         * */

        //创建MutlCastSocket对象
        MulticastSocket ms = new MulticastSocket(10086);

        //将本机地址添加到224.0.0.1的这一组播地址中
        InetAddress byName = InetAddress.getByName("224.0.0.1");
        ms.joinGroup(byName);

        //创建DatagrampPacket对象
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);

        ms.receive(dp);
        byte[] data = dp.getData();
        int len = dp.getLength();
        String str = new String(data, 0, len);

        String hostName = dp.getAddress().getHostName();

        int port = dp.getPort();

        System.out.println(hostName + "从" + port + "端口发送了" + str);
        ms.close();
    }
}
