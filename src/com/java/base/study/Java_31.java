package com.java.base.study;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

//编写HTTP Server
public class Java_31 {

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(6666);
            System.out.println("server is running...");
            for (; ; ) {
                //循环接受访问的请求
                Socket sock = serverSocket.accept();
                System.out.println("connected from " + sock.getRemoteSocketAddress());
                Thread t = new HandlerThread(sock);
                t.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class HandlerThread extends Thread {
    Socket sock;

    HandlerThread(Socket sock) {
        this.sock = sock;
    }

    public void run() {
        try (InputStream input = this.sock.getInputStream()) {
            try (OutputStream output = this.sock.getOutputStream()) {
                handle(input, output);
            }
        } catch (Exception e) {
            try {
                this.sock.close();
            } catch (IOException ioe) {
            }
            System.out.println("client disconnected.");
        }
    }
    private void handle(InputStream input, OutputStream output) throws IOException {
        System.out.println("Process new http request...");
        BufferedReader reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8));
        // 读取HTTP请求:
        int requestFlag = -1;
        String first = reader.readLine();
        if (first.startsWith("GET / HTTP/1.")) {
            requestFlag = 1;
        }
        if (first.startsWith("GET /favicon.ico HTTP/1.")) {
            requestFlag = 2;
        }
        for (;;) {
            String header = reader.readLine();
            if (header.isEmpty()) { // 读取到空行时, HTTP Header读取完毕
                break;
            }
            System.out.println(header);
        }
        System.out.println(requestFlag > 0 ? "Response OK" : "Response Error");
        switch (requestFlag) {
            case -1:
                writer.write("404 Not Found\r\n");
                writer.write("Content-Length: 0\r\n");
                writer.write("\r\n");
                writer.flush();
                break;
            case 1:
                // 发送成功响应:
                String data = "<html><body><h1>Hello, world!</h1></body></html>";
                int length = data.getBytes(StandardCharsets.UTF_8).length;
                writer.write("HTTP/1.0 200 OK\r\n");
                writer.write("Connection: close\r\n");
                writer.write("Content-Type: text/html\r\n");
                writer.write("Content-Length: " + length + "\r\n");
                writer.write("\r\n"); // 空行标识Header和Body的分隔
                writer.write(data);
                writer.flush();
                break;
            case 2:
//                byte[] b = Java_31.class.getResourceAsStream("/favicon.png").readAllBytes(); //把图片放在bin下
//                writer.write("HTTP/1.0 200 OK\r\n");
//                writer.write("Connection: close\r\n");
//                writer.write("Content-Type: image/x-icon\r\n");
//                writer.write("Content-Length: " + b.length + "\r\n");
//                writer.write("\r\n"); // 空行标识Header和Body的分隔
//                writer.flush();
//                output.write(b);
//                output.flush();
//                break;
        }
    }
}



