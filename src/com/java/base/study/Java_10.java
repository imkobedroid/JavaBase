package com.java.base.study;

import java.io.IOException;
import java.util.Properties;

public class Java_10 {


    public static void main(String[] args) throws IOException {

        //绝对路径
//        String f = "/Users/toushihiroshi/Desktop/JavaBase/src/com/java/base/Test.properties";
        //相对路径

//        1.（无）开头表示当前目录下的
//        String f1 = "src/com/java/base/Test.properties";
//        2.（/）开头的目录表示该目录为根目录的一个子目录
//        String f1 = "/Users/toushihiroshi/Desktop/JavaBase/src/com/java/base/Test.properties";
//        3.（./）开头的目录表示该目录为当前目录（当前目录所在的目录）的一个子目录  跟当前目录下是一个道理
//        String f1 = "./src/com/java/base/Test.properties";
//        4.（../）开头的目录表示该目录为当前目录的父目录
        String f1 = "../JavaBase/src/com/java/base/Test.properties";
        Properties props = new Properties();
        props.load(new java.io.FileInputStream(f1));

        String filepath = props.getProperty("last_open_file");
        String interval = props.getProperty("auto_save_interval", "120");

        System.out.println(filepath);
        System.out.println(interval);
    }


}

