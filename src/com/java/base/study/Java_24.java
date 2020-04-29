package com.java.base.study;


import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//使用ReadWriteLock可以解决这个问题，它保证：
//
//        只允许一个线程写入（其他线程既不能写入也不能读取）；
//        没有写入时，多个线程允许同时读（提高性能）。
public class Java_24 {

    public static void main(String[] args) {

    }
}


class CounterReadWriteLock {
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock readLock = readWriteLock.readLock();
    private final Lock writeLock = readWriteLock.writeLock();
    private int[] counts = new int[10];


    public void inc(int index) {
        writeLock.lock();
        try {
            counts[index] += 1;
        } finally {
            writeLock.unlock();
        }
    }

//    把读写操作分别用读锁和写锁来加锁，在读取时，多个线程可以同时获得读锁，这样就大大提高了并发读的执行效率。
//
//    使用ReadWriteLock时，适用条件是同一个数据，有大量线程读取，但仅有少数线程修改。

    public int[] get() {
        readLock.lock(); // 加读锁
        try {
            return Arrays.copyOf(counts, counts.length);
        } finally {
            readLock.unlock(); // 释放读锁
        }
    }
}