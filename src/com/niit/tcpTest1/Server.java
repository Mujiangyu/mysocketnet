package com.niit.tcpTest1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10000);

        Socket socket = serverSocket.accept();
        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        int b;

        while ((b=br.read())!=-1){
            System.out.print((char)b);

        } System.out.println();
    }
}
