package com.java.base.study;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//哈希算法
//哈希算法（Hash）又称摘要算法（Digest），它的作用是：对任意一组输入数据进行计算，得到一个固定长度的输出摘要。
//
//        哈希算法最重要的特点就是：
//
//        相同的输入一定得到相同的输出；
//        不同的输入大概率得到不同的输出。
//        哈希算法的目的就是为了验证原始数据是否被篡改。
public class Java_13 {

    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {

//        MD5是哈希算法
        // 创建一个MessageDigest实例:
        MessageDigest md = MessageDigest.getInstance("MD5");
        // 反复调用update输入数据:
        md.update("Hello".getBytes("UTF-8"));
        md.update("World".getBytes("UTF-8"));
        byte[] result = md.digest(); // 16 bytes: 68e109f0f40ca72a15e05cc22786f8e6
        System.out.println(new BigInteger(1, result).toString(16));


        //SHA-1是哈希算法包括SHA-0（已废弃）、SHA-1、SHA-256、SHA-512等。
        // 创建一个MessageDigest实例:
        MessageDigest md1 = MessageDigest.getInstance("SHA-1");
        // 反复调用update输入数据:
        md1.update("Hello".getBytes("UTF-8"));
        md1.update("World".getBytes("UTF-8"));
        byte[] result1 = md1.digest(); // 20 bytes: db8ac1c259eb89d4a131b253bacfca5f319d54f2
        System.out.println(new BigInteger(1, result1).toString(16));

    }


}
