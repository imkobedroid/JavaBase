package com.java.base.designPatterns.observer;

public class Test1 {

    public static void main(String[] args) {
        initData(1);
    }


    public static void initData(int a) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    System.out.print("回调完成" + a);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
        System.out.print("异步开始" + a);
    }
}
