package com.niit.InetAddressdemo;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MyInetAddressDemo1 {
    public static void main(String[] args) throws UnknownHostException {
        /*
        *static InetAddress getName(String host)    确定主机名称的ip地址，主机名称可以是机器名称，也可以是IP地址
        *String getHostName()                       获取此IP地址的主机名
        *String getHostAddress()                    返回文本显示中的IP地址字符串
        * */

        //获取InetAddress对象
        //IP对象，可以看作是一台电脑的对象
        InetAddress address = InetAddress.getByName("Norman");
        System.out.println(address);

        String hostAddress = address.getHostAddress();
        System.out.println(hostAddress);

        String hostName = address.getHostName();
        System.out.println(hostName);

    }
}
