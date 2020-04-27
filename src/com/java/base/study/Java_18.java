package com.java.base.study;


//守护线程


import java.time.LocalTime;

//Java程序入口就是由JVM启动main线程，main线程又可以启动其他线程。当所有线程都运行结束时，JVM退出，进程结束。
//
//        如果有一个线程没有退出，JVM进程就不会退出。所以，必须保证所有线程都能及时结束。
//
//        但是有一种线程的目的就是无限循环，例如，一个定时触发任务的线程：
public class Java_18 {
    public static void main(String[] args) {



        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是守护线程");
            }
        });
        t.setDaemon(true);
        t.start();
    }
}



//如果这个线程不结束，JVM进程就无法结束。问题是，由谁负责结束这个线程？
//
//然而这类线程经常没有负责人来负责结束它们。但是，当其他线程结束时，JVM进程又必须要结束，怎么办？
//
//        答案是使用守护线程（Daemon Thread）。
//
//        守护线程是指为其他线程服务的线程。在JVM中，所有非守护线程都执行完毕后，无论有没有守护线程，虚拟机都会自动退出,因此，JVM退出时，不必关心守护线程是否已结束。

class TimerThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println(LocalTime.now());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}