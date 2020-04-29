package com.java.base.study;


//使用ThreadLocal


//Java标准库提供了一个特殊的ThreadLocal，它可以在一个线程中传递同一个对象。


public class Java_29 {
    static ThreadLocal<User> threadLocalUser = new ThreadLocal<>();


    public static void main(String[] args) {

    }

//    void processUser(user) {
//        try {
//            threadLocalUser.set(user);
//            step1();
//            step2();
//        } finally {
//            threadLocalUser.remove();
//        }
//    }
}
