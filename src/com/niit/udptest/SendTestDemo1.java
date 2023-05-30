package com.niit.udptest;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class SendTestDemo1 {
    public static void main(String[] args) throws IOException {
        /*
        * UDP发送数据，数据来自键盘录入，知道输入的数据是886，发送数据结束
        * */

        //采用空参构造，由系统随机分配端口号
        DatagramSocket ds = new DatagramSocket();

        Scanner sc = new Scanner(System.in);
        InetAddress byName = InetAddress.getByName("127.0.0.1");
        int port=10010;
        while (true){
            String str = sc.nextLine();
            if(str.equals("886")){
                break;
            }else {
                byte[] bytes = str.getBytes();
                DatagramPacket dp = new DatagramPacket(bytes,bytes.length,byName,port);

                ds.send(dp);
            }
        }
        ds.close();
/*        //打包数据
        String str = "交个朋友吧！";
        byte[] bytes = str.getBytes();
        InetAddress byAddress = InetAddress.getByName("127.0.0.1");
        //发送到哪个端口
        int port = 10086;
        DatagramPacket dp = new DatagramPacket(bytes,bytes.length);*/
    }
}
