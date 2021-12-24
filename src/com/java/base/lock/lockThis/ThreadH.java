package com.java.base.lock.lockThis;

public class ThreadH extends Thread{

    public ThreadH(ObjectService objectService){
        super();
    }

    @Override
    public void run() {
        super.run();
        ObjectService.serviceMethodH();
    }
}
