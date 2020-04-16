package com.java.base;



public class ThreadPoolTest {

    public static void main(String[] args) {

        //简单的开启一个线程
//        new Thread(){
//            @Override
//            public void run() {
//                super.run();
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.print("线程已经完成");
//            }
//        }.start();


        //利用Runnable开启一个线程
//        Runnable runnable=new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.print("线程已经完成");
//            }
//        };
//        new Thread(runnable).start();


        //利用线程池开启
        //ThreadPoolExecutor threadPool=new ThreadPoolExecutor();


    }

}
