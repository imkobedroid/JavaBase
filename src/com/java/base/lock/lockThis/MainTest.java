package com.java.base.lock.lockThis;


//https://blog.csdn.net/luckey_zh/article/details/53815694
//当一个线程访问ObjectService的一个synchronized (this)同步代码块时，其它线程对同一个ObjectService中其它的synchronized (this)同步代码块的访问将是堵塞，这说明synchronized (this)使用的对象监视器是一个。
public class MainTest {
    public static void main(String[] args) {
        ObjectService service = new ObjectService();
        ObjectService service1 = new ObjectService();

        //验证一
//        ThreadA a = new ThreadA(service);
//        a.start();
//        ThreadB b = new ThreadB(service);
//        b.start();


        //验证二
//        ThreadC c = new ThreadC(service);
//        c.start();
//        ThreadD d = new ThreadD(service);
//        d.start();


        //验证三
//        ThreadD d = new ThreadD(service);
//        d.start();
//        ThreadE e = new ThreadE(service);
//        e.start();

//
//        ThreadE e = new ThreadE(service);
//        e.start();
//        ThreadF f = new ThreadF(service);
//        f.start();


//        ThreadC c = new ThreadC(service);
//        c.start();
//        ThreadF f = new ThreadF(service);
//        f.start();


//        ThreadF f = new ThreadF(service);
//        f.start();
//        ThreadG g = new ThreadG(service);
//        g.start();

//
//        ThreadA a = new ThreadA(service);
//        a.setName("a");
//        a.start();
//        ThreadA a1 = new ThreadA(service1);
//        a1.setName("a1");
//        a1.start();


//        ThreadF a1 = new ThreadF(service1);
//        a1.setName("a1");
//        a1.start();
//        ThreadF a2 = new ThreadF(service1);
//        a2.setName("a2");
//        a2.start();


//        ThreadG a1 = new ThreadG(service1);
//        a1.setName("a1");
//        a1.start();
//        ThreadG a3 = new ThreadG(service);
//        a3.setName("a3");
//        a3.start();


        ThreadH a1 = new ThreadH(service1);
        a1.setName("a1");
        a1.start();
        ThreadH a3 = new ThreadH(service);
        a3.setName("a3");
        a3.start();


    }
}


/*
结论是：

synchronized(this)  是对当前对象的这个方法枷锁，如果对象不同则异步
synchronized(Object.class)  是对Object这个类的所有对象进行方法枷锁，所有对象执行到这个方法都要等待锁
synchronized static 是对Object这个类的所有对象进行方法枷锁，所有对象执行到这个方法都要等待锁

一个类中用到了synchronized static跟synchronized(this)或者synchronized(当前类.class)，表示都是锁住了当前同个对象的这个类的方法，所以都是阻塞等待锁


synchronized static与synchronized 的区别：
synchronized是对单个对象的枷锁
synchronized static是对一个class类的所有对象枷锁

*/