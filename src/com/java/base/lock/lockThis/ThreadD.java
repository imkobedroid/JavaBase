package com.java.base.lock.lockThis;

public class ThreadD extends Thread{
    private final ObjectService objectService;

    public ThreadD(ObjectService objectService){
        super();
        this.objectService=objectService;
    }

    @Override
    public void run() {
        super.run();
        objectService.serviceMethodD();
    }
}
