package com.java.base.study;


//使用wait和notify
//一个加锁函数执行完成后会自动释放锁
//生产者消费者模型

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static com.java.base.study.Java_21.LOCK;

public class Java_21 {
    static final String LOCK = "lock";

    public static void main(String[] args) throws InterruptedException {


        TaskQueue q = new TaskQueue();
        List<Thread> ts = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(() -> {
                // 执行task:
                while (true) {
                    try {
                        String s = q.getTask();
                        System.out.println("execute task: " + s);
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            });
            t.start();
            ts.add(t);
        }
        Thread add = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                // 放入task:
                String s = "t-" + Math.random();
                System.out.println("add task: " + s);
                q.addTask(s);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        add.start();
        add.join();
        Thread.sleep(100);
        for (Thread thread : ts) {
            thread.interrupt();
        }
    }
}

class TaskQueue {
    private Queue<String> stringQueue = new LinkedList<>();

    public  void addTask(String s) {
        synchronized(LOCK){
            stringQueue.add(s);
//        if (stringQueue.size()==100){
//            LOCK.notifyAll();  // 唤醒在this锁等待的所有线程
//
//        }

            LOCK.notifyAll();
        }
    }


    public  String getTask() throws InterruptedException {
        synchronized (LOCK){
            while (stringQueue.isEmpty()) {
                LOCK.wait();
            }
            return stringQueue.remove();
        }
    }
}
