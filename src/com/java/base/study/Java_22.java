package com.java.base.study;


//ReentrantLock


//我们知道Java语言直接提供了synchronized关键字用于加锁，但这种锁一是很重，二是获取时必须一直等待，没有额外的尝试机制。
//
//        java.util.concurrent.locks包提供的ReentrantLock用于替代synchronized加锁，我们来看一下传统的synchronized代码：


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Java_22 {
    public static void main(String[] args) {

    }
}

//synchronized加锁
class CounterInfoSynchronized {
    private int count;

    public void add(int a) {
        synchronized (this) {
            count += a;
        }
    }
}

//ReentrantLock加锁
class CounterReentrantLock {
    private final Lock lock = new ReentrantLock();
    private int count;

    public void add(int a) {
        lock.lock();
        try {
            count += a;
        } finally {
            lock.unlock();
        }
    }


    //试获取锁的时候，最多等待1秒。如果1秒后仍未获取到锁，tryLock()返回false，程序就可以做一些额外处理，而不是无限等待下去。使用ReentrantLock比直接使用synchronized更安全，线程在tryLock()失败的时候不会导致死锁。
    public void getLock(int a) {
        try {
            if (lock.tryLock(1, TimeUnit.SECONDS)) {
                try {
                    count += a;
                } finally {
                    lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

