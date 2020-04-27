package com.java.base.study;


//创建线程

//线程的状态
//        New：新创建的线程，尚未执行；
//        Runnable：运行中的线程，正在执行run()方法的Java代码；
//        Blocked：运行中的线程，因为某些操作被阻塞而挂起；
//        Waiting：运行中的线程，因为某些操作在等待中；
//        Timed Waiting：运行中的线程，因为执行sleep()方法正在计时等待；
//        Terminated：线程已终止，因为run()方法执行完毕。




public class Java_17 {

    public static void main(String[] args) throws InterruptedException {

        //主线程中开启了一个子线程，开启之后，主线程与子线程互不影响各自的生命周期，即主线程结束，子线程还可以继续执行；子线程介素，主线程也能继续执行。

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println("子线程执行完成");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }).start();

        System.out.println("main线程执行完成");


//        System.out.println("main start...");
//        Thread t = new Thread(() -> {
//            System.out.println("thread run...");
//            System.out.println("thread end.");
//        });
//        t.start();
//        System.out.println("main end...");


//        当main线程对线程对象t调用join()方法时，主线程将等待变量t表示的线程运行结束，即join就是指等待该线程结束，然后才继续往下执行自身线程。
//        Thread t = new Thread(() -> {
//            System.out.println("hello");
//        });
//        System.out.println("start");
//        t.start();
//        t.join();
//        System.out.println("end");


//        Thread thread = new Thread(() -> {
//            try {
//                System.out.println("我是第一个线程正在执行");
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        );
//
//        Thread thread1 = new Thread(() -> {
//            try {
//                System.out.println("我是第二个线程开始执行");
//                thread.join();
//                System.out.println("第一个线程执行完毕，我完成接下来的工作");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        thread.start();
//        thread1.start();

        //中断线程
//        Thread t = new MyThread();
//        t.start();
//        Thread.sleep(1000); // 暂停1毫秒
//        t.interrupt(); // 中断t线程
//        t.join(); // 等待t线程结束
//        System.out.println("end");
//
//



//        main线程通过调用t.interrupt()从而通知t线程中断，而此时t线程正位于hello.join()的等待中，此方法会立刻结束等待并抛出InterruptedException。由于我们在t线程中捕获了InterruptedException，因此，就可以准备结束该线程。在t线程结束前，对hello线程也进行了interrupt()调用通知其中断。如果去掉这一行代码，可以发现hello线程仍然会继续运行，且JVM不会退出。

//        Thread t = new MyThread();
//        t.start();
//        Thread.sleep(1000);
//        t.interrupt(); // 中断t线程
//        t.join(); // 等待t线程结束
//        System.out.println("end");



//        另一个常用的中断线程的方法是设置标志位。我们通常会用一个running标志位来标识线程是否应该继续运行，在外部线程中，通过把HelloThread.running置为false，就可以让线程结束：

//        HelloThread t = new HelloThread();
//        t.start();
//        Thread.sleep(1);
//        t.running = false; // 标志位置为false
    }

}





class HelloThread extends Thread {
    public volatile boolean running = true;
    public void run() {
        int n = 0;
        while (running) {
            n ++;
            System.out.println(n + " hello!");
        }
        System.out.println("end!");
    }
}


//class MyThread extends Thread {
//    public void run() {
//        Thread hello = new HelloThread();
//        hello.start(); // 启动hello线程
//        try {
//            hello.join(); // 等待hello线程结束
//        } catch (InterruptedException e) {
//            System.out.println("interrupted!");
//        }
//        hello.interrupt();
//    }
//}
//
//class HelloThread extends Thread {
//    public void run() {
//        int n = 0;
//        while (!isInterrupted()) {
//            n++;
//            System.out.println(n + " hello!");
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                break;
//            }
//        }
//    }
//}




//class MyThread extends Thread {
//    public void run() {
//        int n = 0;
//        while (!isInterrupted()) {
//            n++;
//            System.out.println(n + " hello!");
//        }
//    }
//}
