package com.java.base.lock.lockThis;

public class ThreadB extends Thread{
    private final ObjectService objectService;

    public ThreadB(ObjectService objectService){
        super();
        this.objectService=objectService;
    }

    @Override
    public void run() {
        super.run();
        objectService.serviceMethodB();
    }
}
