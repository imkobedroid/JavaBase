package com.java.base.study;


//编码算法


//        URL编码和Base64编码都是编码算法，它们不是加密算法；
//        URL编码的目的是把任意文本数据编码为%前缀表示的文本，便于浏览器和服务器处理；
//
//        Base64编码的目的是把任意二进制数据编码为文本，但编码后数据量会增加1/3。

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

public class Java_12 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //url编码实现服务器的通用型，如果URL中包含中文、日文这些非ASCII字符怎么办？不要紧，URL编码有一套规则：
//        如果字符是A~Z，a~z，0~9以及-、_、.、*，则保持不变；
//        如果是其他字符，先转换为UTF-8编码，然后对每个字节以%XX表示。
        String encoded = URLEncoder.encode("中文", String.valueOf(StandardCharsets.UTF_8));
        System.out.println(encoded);


        //对url进行解码
        String decode = URLDecoder.decode("%E4%B8%AD%E6%96%87%21", String.valueOf(StandardCharsets.UTF_8));
        System.out.println(decode);


//      URL编码是对字符进行编码，表示成%xx的形式，而Base64编码是对二进制数据进行编码，表示成文本格式。
//        Base64编码可以把任意长度的二进制数据变为纯文本，且只包含A~Z、a~z、0~9、+、/、=这些字符。它的原理是把3字节的二进制数据按6bit一组，用4个int整数表示，然后查表，把int整数用索引对应到字符，得到编码后的字符串。
        byte[] input = new byte[]{(byte) 0xe4, (byte) 0xb8, (byte) 0xad};
        String b64encoded = Base64.getEncoder().encodeToString(input);
        System.out.println(b64encoded);

        byte[] output = Base64.getDecoder().decode("5Lit");
        System.out.println(Arrays.toString(output)); // [-28, -72, -83]


    }

}
