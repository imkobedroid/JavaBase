package com.java.base.study;


//线程同步
public class Java_19 {

    public static void main(String[] args) throws InterruptedException {


//        AddThread add = new AddThread();
//        DecThread dec = new DecThread();
//        add.start();
//        dec.start();
//        add.join();
//        dec.join();
//        System.out.println(Counter.count);




        CounterInfo c1 = new CounterInfo();
        CounterInfo c2 = new CounterInfo();

// 对c1进行操作的线程:
        new Thread(() -> {
            c1.add(1);
        }).start();
        new Thread(() -> {
            c1.dec(1);
        }).start();

// 对c2进行操作的线程:
        new Thread(() -> {
            c2.add(1);
        }).start();
        new Thread(() -> {
            c2.dec(1);
        }).start();


    }
}

class Counter {
    public static final Object lock = new Object();
    public static int count = 0;
}

class AddThread extends Thread {
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (Counter.lock) {
                Counter.count += 1;
            }
        }
    }
}

class DecThread extends Thread {
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (Counter.lock) {
                Counter.count -= 1;
            }
        }
    }
}




//自己同步锁住自己实例对象


//这样一来，线程调用add()、dec()方法时，它不必关心同步逻辑，因为synchronized代码块在add()、dec()方法内部。并且，我们注意到，synchronized锁住的对象是this，即当前实例，这又使得创建多个Counter实例的时候，它们之间互不影响，可以并发执行：
 class CounterInfo {
    private int count = 0;

    public void add(int n) {
        synchronized(this) {
            count += n;
        }
    }

    public void dec(int n) {
        synchronized(this) {
            count -= n;
        }
    }

    public synchronized void addInfo(int n) { // 等价于方法add
        count += n;
    } // 解锁

    public int get() {
        return count;
    }
}
