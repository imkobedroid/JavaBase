package com.java.base.study;


//多线程

//Java语言虽然内置了多线程支持，启动一个新线程非常方便，但是，创建线程需要操作系统资源（线程资源，栈空间等），频繁创建和销毁大量线程需要消耗大量时间。


//FixedThreadPool：线程数固定的线程池；
//        CachedThreadPool：线程数根据任务动态调整的线程池；
//        SingleThreadExecutor：仅单线程执行的线程池。

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Java_26 {
    public static void main(String[] args) {
        // 创建固定大小的线程池:
//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        executorService.submit(task1());
//        executorService.submit(task2());
//        executorService.submit(task3());
//        executorService.submit(task4());
//        executorService.shutdown();


//        线程池在程序结束的时候要关闭。使用shutdown()方法关闭线程池的时候，它会等待正在执行的任务先完成，然后再关闭。shutdownNow()会立刻停止正在执行的任务，awaitTermination()则会等待指定的时间让线程池关闭。

//        ExecutorService es = Executors.newFixedThreadPool(4);
//        for (int i = 0; i < 6; i++) {
//            es.submit(new Task("" + i));
//        }
//        // 关闭线程池:
//        es.shutdown();
//
//
////        如果我们想把线程池的大小限制在4～10个之间动态调整怎么办？
//        int min = 4;
//        int max = 10;
//        ExecutorService executorService = new ThreadPoolExecutor(min, max,
//                60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
//


//        还有一种任务，需要定期反复执行，例如，每秒刷新证券价格。这种任务本身固定，需要反复执行的，可以使用ScheduledThreadPool。放入ScheduledThreadPool的任务可以定期反复执行。

        ScheduledExecutorService ses = Executors.newScheduledThreadPool(4);
//        ses.schedule(new Task("one-time"), 1, TimeUnit.SECONDS);
//        如果任务以固定的每3秒执行，我们可以这样写：
//        ses.scheduleAtFixedRate(new Task("fixed-rate"), 2, 3, TimeUnit.SECONDS);
//        如果任务以固定的3秒为间隔执行，我们可以这样写：
        ses.scheduleWithFixedDelay(new Task("fixed-delay"), 2, 3, TimeUnit.SECONDS);





    }


    private static Runnable task1() {
        return new Runnable() {
            @Override
            public void run() {
                System.out.println("task1");

            }
        };
    }

    private static Runnable task2() {
        return new Runnable() {
            @Override
            public void run() {
                System.out.println("task2");

            }
        };
    }

    private static Runnable task3() {
        return new Runnable() {
            @Override
            public void run() {
                System.out.println("task3");

            }
        };
    }

    private static Runnable task4() {
        return new Runnable() {
            @Override
            public void run() {
                System.out.println("task4");

            }
        };
    }
}


class Task implements Runnable {

    private final String name;


    Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {

        System.out.println("start task " + name);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        System.out.println("end task " + name);
    }
}


